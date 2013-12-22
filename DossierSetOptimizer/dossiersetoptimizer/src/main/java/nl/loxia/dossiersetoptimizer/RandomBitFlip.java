package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class RandomBitFlip implements IMutatie {
    private static final Random rng            = new Random();
    private static final float  MUTATIE_FACTOR = 0.05f;

    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < MUTATIE_FACTOR;
    }

    public void muteer(Oplossing oplossing) {
        oplossing.getSelectie().flip(rng.nextInt(oplossing.size()));
        oplossing.setDirty();
    }

}
