package nl.loxia.dossiersetoptimizer;

import java.util.BitSet;
import java.util.Random;

public class Oplossing {
    private static final Random rng = new Random();

    private BitSet              selectie;
    private int                 fitness;
    private Probleem            probleem;

    public Oplossing(Probleem probleem, BitSet dna) {
        this.probleem = probleem;
        selectie = dna;
        fitness = probleem.evalueer(this);
    }

    public Oplossing(Probleem probleem) {
        this.probleem = probleem;
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

    public Oplossing crossover(Oplossing parent2) {
        BitSet dna = new BitSet();

        for (int i = 0; i < probleem.getDossiers().size(); ++i) {
            if (rng.nextBoolean()) {
                dna.set(i, selectie.get(i));
            } else {
                dna.set(i, parent2.getSelectie().get(i));
            }
        }

        return new Oplossing(probleem, dna);
    }

    @Override
    public String toString() {
        return "Fitness: " + fitness;
    }
}
