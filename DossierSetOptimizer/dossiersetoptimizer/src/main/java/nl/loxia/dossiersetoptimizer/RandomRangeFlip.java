package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class RandomRangeFlip implements IMutatie {
    private static final Random rng            = new Random();
    private static final float  MUTATIE_FACTOR = 0.05f;

    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < MUTATIE_FACTOR;
    }

    public void muteer(Oplossing oplossing) {
        int point1 = rng.nextInt(oplossing.size());
        int point2 = rng.nextInt(oplossing.size());

        oplossing.getSelectie().flip(Math.min(point1, point2), Math.max(point1, point2));
        oplossing.setDirty();
    }
}
