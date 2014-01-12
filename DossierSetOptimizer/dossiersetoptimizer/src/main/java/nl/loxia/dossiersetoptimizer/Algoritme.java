package nl.loxia.dossiersetoptimizer;

import java.util.ArrayList;
import java.util.List;

public class Algoritme extends Thread {
    private static final int GENERATIE_SIZE = 20;
    private Generatie        huidigeGeneratie;

    private List<IMutatie>   mutaties       = new ArrayList<IMutatie>();
    private Distributor      distributor;
    private Probleem         probleem;

    public Algoritme(Probleem probleem, Distributor distributor) {
        this.probleem = probleem;
        this.distributor = distributor;
        huidigeGeneratie = new Generatie(GENERATIE_SIZE);
        huidigeGeneratie.populateRandom(probleem);

        mutaties.add(new RandomBitFlip(0.05f));
        mutaties.add(new RandomMultiFlip(0.05f));
        mutaties.add(new RandomRangeFlip(0.02f));
        mutaties.add(new NewSeedMutatie(probleem, 0.1f));
        mutaties.add(new LocalOptimizeRemoveUnnecessary(0.01f));
        mutaties.add(new LocalOptimizeSwitchBit(0.01f));
        mutaties.add(new AddAndOptimize(0.01f));
    }

    @Override
    public void run() {
        solve(probleem);
    }

    private void solve(Probleem probleem) {
        boolean run = true;
        int beste = -1;
        while (run) {
            int bladenInOplossing = probleem.bladenInOplossing(huidigeGeneratie.getBesteOplossing());
            if (beste == -1 || bladenInOplossing < beste) {
                distributor.callback(huidigeGeneratie.getBesteOplossing(), bladenInOplossing);
                beste = bladenInOplossing;
            }

            Generatie nieuweGeneratie = new Generatie(GENERATIE_SIZE);
            nieuweGeneratie.populateCrossover(huidigeGeneratie);

            muteer(nieuweGeneratie);

            huidigeGeneratie = nieuweGeneratie;
        }
    }

    private void muteer(Generatie generatie) {
        for (int i = 1; i < generatie.getPopulatie().size(); ++i) {
            for (IMutatie mutatie : mutaties) {
                if (mutatie.mutatieVindtPlaats()) {
                    mutatie.muteer(generatie.getPopulatie().get(i));
                }
            }
        }
    }
}
