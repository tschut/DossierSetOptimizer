package nl.loxia.dossiersetoptimizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Generatie {
    private static final Random rng = new Random();

    private int                 size;
    private List<Oplossing>     populatie;

    public Generatie(int size) {
        this.size = size;
        populatie = new ArrayList<Oplossing>(size);
    }

    public void populateRandom(Probleem probleem) {
        for (int i = 0; i < size; ++i) {
            populatie.add(new Oplossing(probleem));
        }
        sortPopulatie();
    }

    private void sortPopulatie() {
        Collections.sort(populatie, new Comparator<Oplossing>() {
            public int compare(Oplossing o1, Oplossing o2) {
                return o2.getFitness() - o1.getFitness();
            }
        });
    }

    public Oplossing getBesteOplossing() {
        return populatie.get(0);
    }

    private int berekenTotalFitness() {
        int totalFitness = 0;
        for (Oplossing oplossing : populatie) {
            totalFitness += oplossing.getFitness();
        }
        return totalFitness;
    }

    public void populateCrossover(Generatie huidigeGeneratie) {
        populatie.add(huidigeGeneratie.getBesteOplossing());

        int totalFitness = huidigeGeneratie.berekenTotalFitness();

        while (populatie.size() < size) {
            Oplossing parent1 = huidigeGeneratie.select(rng.nextInt(totalFitness));
            Oplossing parent2 = huidigeGeneratie.select(rng.nextInt(totalFitness));
            Oplossing child = parent1.crossover(parent2);
            populatie.add(child);
        }
        sortPopulatie();
    }

    private Oplossing select(int selection) {
        int index = -1;
        do {
            selection -= populatie.get(++index).getFitness();
        } while (selection > 0);
        return populatie.get(index);
    }

    public void printPopulatie() {
        for (int i = 0; i < populatie.size(); ++i) {
            System.out.print(populatie.get(i).getFitness());
            if (i < populatie.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
