package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class RandomBitFlip implements IMutatie {
    private static final Random rng = new Random();
    private float               mutatieFactor;

    public RandomBitFlip(float mutatieFactor) {
        this.mutatieFactor = mutatieFactor;
    }

    @Override
    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < mutatieFactor;
    }

    @Override
    public void muteer(Oplossing oplossing) {
        oplossing.getSelectie().flip(rng.nextInt(oplossing.size()));
        oplossing.setDirty();
    }

}
