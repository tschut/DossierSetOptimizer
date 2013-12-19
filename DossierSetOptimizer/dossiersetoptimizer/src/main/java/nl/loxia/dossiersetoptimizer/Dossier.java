package nl.loxia.dossiersetoptimizer;

import java.util.List;

public class Dossier implements Comparable<Dossier> {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((naam == null) ? 0 : naam.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dossier other = (Dossier) obj;
        if (naam == null) {
            if (other.naam != null)
                return false;
        } else if (!naam.equals(other.naam))
            return false;
        return true;
    }

    public int compareTo(Dossier other) {
        return naam.compareTo(other.naam);
    }
}
