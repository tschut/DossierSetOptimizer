package nl.loxia.dossiersetoptimizer;

public class Algoritme {
    private Probleem  probleem;
    private Oplossing oplossing;

    public Algoritme(Probleem probleem) {
        this.probleem = probleem;
        oplossing = new Oplossing(probleem);
        probleem.printOplossing(oplossing);
    }

}
