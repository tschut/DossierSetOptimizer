package nl.loxia.dossiersetoptimizer;

public class Distributor {
    private final static int populations = Runtime.getRuntime().availableProcessors();
    private long             startTime   = System.currentTimeMillis();
    private Probleem         probleem;
    int                      best        = -1;

    public Distributor(Probleem probleem) {
        this.probleem = probleem;

        for (int i = 0; i < populations; ++i) {
            Algoritme alg = new Algoritme(probleem, this);
            alg.start();
        }
    }

    public synchronized void callback(Oplossing oplossing, int bladen) {
        if (best == -1 || bladen < best) {
            probleem.printOplossing((System.currentTimeMillis() - startTime) / 1000 + ",", oplossing, bladen);
            best = bladen;
        }
    }
}
