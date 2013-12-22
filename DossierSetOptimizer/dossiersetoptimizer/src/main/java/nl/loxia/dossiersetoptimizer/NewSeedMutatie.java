package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class NewSeedMutatie implements IMutatie {
    private static final Random rng            = new Random();
    private static final float  MUTATIE_FACTOR = 0.05f;
    private Probleem            probleem;

    public NewSeedMutatie(Probleem probleem) {
        this.probleem = probleem;
    }

    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < MUTATIE_FACTOR;
    }

    public void muteer(Oplossing oplossing) {
        for (int i = 0; i < oplossing.size(); ++i) {
            oplossing.getSelectie().set(i, rng.nextBoolean());
        }

        while (!probleem.isGeldigeOplossing(oplossing)) {
            oplossing.getSelectie().set(rng.nextInt(oplossing.size()));
        }
        oplossing.setDirty();
    }
}
