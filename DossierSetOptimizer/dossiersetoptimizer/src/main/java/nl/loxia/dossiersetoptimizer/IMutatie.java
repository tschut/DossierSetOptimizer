package nl.loxia.dossiersetoptimizer;

public interface IMutatie {
    public boolean mutatieVindtPlaats();

    public void muteer(Oplossing oplossing);
}
