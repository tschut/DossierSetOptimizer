package nl.loxia.dossiersetoptimizer;

import java.util.TreeSet;

public class Oplossing {
    private TreeSet<Integer> oplossing = new TreeSet<Integer>();

    // lager = beter
    public int evalueer() {
        // todo: test of we alle fouten hebben, anders veel strafpunten!

        return oplossing.size();
    }
}
