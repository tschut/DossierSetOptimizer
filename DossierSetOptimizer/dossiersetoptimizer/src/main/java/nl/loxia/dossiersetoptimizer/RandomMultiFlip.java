package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class RandomMultiFlip implements IMutatie {
    private static final Random rng            = new Random();
    private static final float  MUTATIE_FACTOR = 0.05f;

    @Override
    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < MUTATIE_FACTOR;
    }

    @Override
    public void muteer(Oplossing oplossing) {
        int count = rng.nextInt(10);
        for (int i = 0; i < count; ++i) {
            oplossing.getSelectie().flip(rng.nextInt(oplossing.size()));
        }
        oplossing.setDirty();
    }
}
