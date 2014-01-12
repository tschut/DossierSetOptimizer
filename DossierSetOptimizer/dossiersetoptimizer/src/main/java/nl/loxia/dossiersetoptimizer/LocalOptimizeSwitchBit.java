package nl.loxia.dossiersetoptimizer;

import java.util.BitSet;
import java.util.Random;

public class LocalOptimizeSwitchBit implements IMutatie {
    private static final Random rng = new Random();
    private float               mutatieFactor;

    public LocalOptimizeSwitchBit(float mutatieFactor) {
        this.mutatieFactor = mutatieFactor;
    }

    @Override
    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < mutatieFactor;
    }

    @Override
    public void muteer(Oplossing oplossing) {
        int startFitness = oplossing.getFitness();
        BitSet selectie = oplossing.getSelectie();
        if (selectie.cardinality() == 0) {
            return;
        }

        int selectedBit = getSelectedBit(selectie, oplossing.size());

        selectie.clear(selectedBit);
        boolean success = false;
        for (int i = selectie.nextClearBit(0); i >= 0; i = selectie.nextClearBit(i + 1)) {
            selectie.set(i);
            if (oplossing.getFitness(true) < startFitness) {
                selectie.clear(i);
            } else {
                success = true;
                break;
            }
        }
        if (!success) {
            selectie.set(selectedBit);
        }
        oplossing.getFitness(true);
    }

    private int getSelectedBit(BitSet selectie, int size) {
        while (true) {
            int index = rng.nextInt(size);
            if (selectie.get(index)) {
                return index;
            }
        }
    }
}
