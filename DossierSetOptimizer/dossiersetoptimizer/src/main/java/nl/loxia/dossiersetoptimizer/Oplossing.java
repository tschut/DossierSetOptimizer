package nl.loxia.dossiersetoptimizer;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Oplossing {
    private TreeSet<Dossier> dossiers = new TreeSet<Dossier>();

    public Set<String> getAlleMeldingen() {
        Set<String> alleMeldingen = new HashSet<String>();
        for (Dossier dossier : dossiers) {
            alleMeldingen.addAll(dossier.getMeldingen());
        }
        return alleMeldingen;
    }

    public Set<Dossier> getDossiers() {
        return dossiers;
    }

}
