package nl.loxia.dossiersetoptimizer;

import java.util.HashSet;
import java.util.Set;

public class Probleem {
    private Set<Dossier>     dossiers                    = new HashSet<Dossier>();
    private Set<String>      alleMeldingen               = new HashSet<String>();

    private static final int NIET_ALLE_MELDINGEN_PENALTY = 1000;

    // lager = beter
    public int evalueer(Oplossing oplossing) {
        if (alleMeldingen.size() != oplossing.getAlleMeldingen().size()) {
            return NIET_ALLE_MELDINGEN_PENALTY;
        }

        return oplossing.getDossiers().size();
    }
}
