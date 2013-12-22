package nl.loxia.dossiersetoptimizer;

import java.util.Arrays;
import java.util.List;

public class Algoritme {
    private static final int GENERATIE_SIZE   = 100;
    private Generatie        huidigeGeneratie;
    private int              generatieCounter = 0;

    private List<IMutatie>   mutaties         = Arrays.asList();

    public Algoritme(Probleem probleem) {
        huidigeGeneratie = new Generatie(GENERATIE_SIZE);
        huidigeGeneratie.populateRandom(probleem);

        boolean run = true;
        while (run) {
            probleem.printOplossing(generatieCounter + ": ", huidigeGeneratie.getBesteOplossing());
            // huidigeGeneratie.printPopulatie();

            Generatie nieuweGeneratie = new Generatie(GENERATIE_SIZE);
            nieuweGeneratie.populateCrossover(huidigeGeneratie);

            muteer(nieuweGeneratie);

            huidigeGeneratie = nieuweGeneratie;
            generatieCounter++;

            if (generatieCounter > 1000) {
                run = false;
            }
        }
    }

    private void muteer(Generatie generatie) {
        for (Oplossing oplossing : generatie.getPopulatie()) {
            for (IMutatie mutatie : mutaties) {
                if (mutatie.mutatieVindtPlaats()) {
                    mutatie.muteer(oplossing);
                }
            }
        }
    }
}
