package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class RandomMultiFlip implements IMutatie {
    private static final Random rng = new Random();
    private float               mutatieFactor;

    public RandomMultiFlip(float mutatieFactor) {
        this.mutatieFactor = mutatieFactor;
    }

    @Override
    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < mutatieFactor;
    }

    @Override
    public void muteer(Oplossing oplossing) {
        int count = rng.nextInt(oplossing.size() / 10);
        for (int i = 0; i < count; ++i) {
            oplossing.getSelectie().flip(rng.nextInt(oplossing.size()));
        }
        oplossing.setDirty();
    }
}
