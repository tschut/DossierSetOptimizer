package nl.loxia.dossiersetoptimizer;

import java.util.BitSet;
import java.util.Random;

public class Oplossing {
    private static final Random rng = new Random();

    private BitSet              selectie;

    public Oplossing(Probleem probleem) {
        selectie = new BitSet(probleem.getDossiers().size());

        for (int i = 0; i < probleem.getDossiers().size(); ++i) {
            selectie.set(i, rng.nextBoolean());
        }
    }

    public BitSet getSelectie() {
        return selectie;
    }
}
