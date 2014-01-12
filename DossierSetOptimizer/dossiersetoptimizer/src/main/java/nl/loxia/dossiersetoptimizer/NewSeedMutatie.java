package nl.loxia.dossiersetoptimizer;

import java.util.Random;

public class NewSeedMutatie implements IMutatie {
    private static final Random rng = new Random();
    private float               mutatieFactor;
    private Probleem            probleem;

    public NewSeedMutatie(Probleem probleem, float mutatieFactor) {
        this.probleem = probleem;
        this.mutatieFactor = mutatieFactor;
    }

    @Override
    public boolean mutatieVindtPlaats() {
        return rng.nextFloat() < mutatieFactor;
    }

    @Override
    public void muteer(Oplossing oplossing) {
        for (int i = 0; i < oplossing.size(); ++i) {
            oplossing.getSelectie().set(i, rng.nextBoolean());
        }

        while (!probleem.isGeldigeOplossing(oplossing)) {
            int bit = oplossing.getSelectie().nextClearBit(rng.nextInt(oplossing.size()));
            if (bit < oplossing.size()) {
                oplossing.getSelectie().set(bit);
            }
        }
        oplossing.setDirty();
    }
}
