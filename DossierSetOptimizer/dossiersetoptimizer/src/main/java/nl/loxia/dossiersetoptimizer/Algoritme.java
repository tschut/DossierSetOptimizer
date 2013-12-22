package nl.loxia.dossiersetoptimizer;

public class Algoritme {
    private Probleem probleem;

    public Algoritme(Probleem probleem) {
        this.probleem = probleem;

        Generatie huidigeGeneratie = new Generatie(100);
        huidigeGeneratie.populateRandom(probleem);

    }

}
