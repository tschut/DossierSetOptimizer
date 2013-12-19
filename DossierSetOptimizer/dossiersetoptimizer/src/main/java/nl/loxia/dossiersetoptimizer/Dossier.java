package nl.loxia.dossiersetoptimizer;

import java.util.List;

public class Dossier {
    private String       naam;
    private List<String> meldingen;
    private int          bladCount;

    public Dossier(String naam, List<String> meldingen, int bladCount) {
        this.naam = naam;
        this.meldingen = meldingen;
        this.bladCount = bladCount;
    }

    public String getNaam() {
        return naam;
    }

    public List<String> getMeldingen() {
        return meldingen;
    }

    public int getBladCount() {
        return bladCount;
    }
}
