package nl.loxia.dossiersetoptimizer;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AddAndOptimize implements IMutatie {
    private static final Random rng = new Random();
    private float               mutatieFactor;

    public AddAndOptimize(float mutatieFactor) {
        this.mutatieFactor = mutatieFactor;
    }

    @Override
    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < mutatieFactor;
    }

    @Override
    public void muteer(Oplossing oplossing) {
        int count = rng.nextInt(oplossing.size());
        for (int i = 0; i < count; ++i) {
            oplossing.getSelectie().set(rng.nextInt(oplossing.size()));
        }

        localOptimize(oplossing);
        localOptimize(oplossing);
    }

    private void localOptimize(Oplossing oplossing) {
        int startFitness = oplossing.getFitness();
        BitSet selectie = oplossing.getSelectie();

        List<Integer> bits = new ArrayList<Integer>();
        for (int i = selectie.nextSetBit(0); i >= 0; i = selectie.nextSetBit(i + 1)) {
            bits.add(i);
        }
        Collections.shuffle(bits, rng);

        for (Integer i : bits) {
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
