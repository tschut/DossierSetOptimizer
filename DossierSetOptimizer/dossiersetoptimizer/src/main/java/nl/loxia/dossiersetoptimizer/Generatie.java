package nl.loxia.dossiersetoptimizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Generatie {
    private int             size;
    private List<Oplossing> populatie;

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

    public void populateCrossover(Generatie huidigeGeneratie) {
        // TODO Auto-generated method stub
    }
}
