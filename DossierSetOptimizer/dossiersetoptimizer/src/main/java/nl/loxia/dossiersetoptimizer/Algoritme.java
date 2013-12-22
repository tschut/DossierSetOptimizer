package nl.loxia.dossiersetoptimizer;

public class Algoritme {
    private static final int GENERATIE_SIZE   = 100;

    private Generatie        huidigeGeneratie;

    private int              generatieCounter = 0;

    public Algoritme(Probleem probleem) {
        huidigeGeneratie = new Generatie(GENERATIE_SIZE);
        huidigeGeneratie.populateRandom(probleem);

        boolean run = true;
        while (run) {
            probleem.printOplossing(generatieCounter + ": ", huidigeGeneratie.getBesteOplossing());

            Generatie nieuweGeneratie = new Generatie(GENERATIE_SIZE);
            nieuweGeneratie.populateCrossover(huidigeGeneratie);

            generatieCounter++;
        }
    }
}
