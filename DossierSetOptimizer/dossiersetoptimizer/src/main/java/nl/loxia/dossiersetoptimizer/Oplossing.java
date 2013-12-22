package nl.loxia.dossiersetoptimizer;

import java.util.BitSet;
import java.util.Random;

public class Oplossing {
    private static final Random rng = new Random();

    private BitSet              selectie;
    private int                 fitness;

    public Oplossing(Probleem probleem) {
        selectie = new BitSet(probleem.getDossiers().size());

        for (int i = 0; i < probleem.getDossiers().size(); ++i) {
            selectie.set(i, rng.nextBoolean());
        }

        while (!probleem.isGeldigeOplossing(this)) {
            selectie.set(rng.nextInt(probleem.getDossiers().size()));
        }

        fitness = probleem.evalueer(this);
    }

    public BitSet getSelectie() {
        return selectie;
    }

    public int getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        return "Fitness: " + fitness;
    }
}
