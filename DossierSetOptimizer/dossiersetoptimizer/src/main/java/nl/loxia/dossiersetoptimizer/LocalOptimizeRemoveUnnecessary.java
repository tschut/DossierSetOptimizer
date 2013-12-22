package nl.loxia.dossiersetoptimizer;

import java.util.BitSet;
import java.util.Random;

public class LocalOptimizeRemoveUnnecessary implements IMutatie {
    private static final Random rng            = new Random();
    private static final float  MUTATIE_FACTOR = 0.05f;

    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < MUTATIE_FACTOR;
    }

    public void muteer(Oplossing oplossing) {
        int startFitness = oplossing.getFitness();
        BitSet selectie = oplossing.getSelectie();

        for (int i = selectie.nextSetBit(0); i >= 0; i = selectie.nextSetBit(i + 1)) {
            selectie.clear(i);
            if (oplossing.getFitness(true) < startFitness) {
                selectie.set(i);
            } else {
                startFitness = oplossing.getFitness();
            }
        }
        oplossing.getFitness(true);
    }
}
