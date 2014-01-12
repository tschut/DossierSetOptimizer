package nl.loxia.dossiersetoptimizer;

import java.util.BitSet;
import java.util.List;

public class Probleem {
    private List<Dossier>    dossiers;
    private int              totaalBladen                = 0;
    private int              totaalMeldingen             = 0;

    private static final int NIET_ALLE_MELDINGEN_PENALTY = -100;

    public Probleem(List<Dossier> dossiers) {
        this.dossiers = dossiers;

        BitSet alleMeldingen = new BitSet();
        for (Dossier dossier : dossiers) {
            alleMeldingen.or(dossier.getMeldingen());
            totaalBladen += dossier.getBladCount();
        }
        totaalMeldingen = alleMeldingen.cardinality();
    }

    // hoger = beter
    public int evalueer(Oplossing oplossing) {
        if (!isGeldigeOplossing(oplossing)) {
            return NIET_ALLE_MELDINGEN_PENALTY;
        }

        return totaalBladen - bladenInOplossing(oplossing);
    }

    public void printOplossing(String prefix, Oplossing oplossing) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(bladenInOplossing(oplossing));
        BitSet selectie = oplossing.getSelectie();
        for (int i = selectie.nextSetBit(0); i >= 0; i = selectie.nextSetBit(i + 1)) {
            sb.append(",").append(dossiers.get(i).getNaam());
        }
        System.out.println(sb.toString());
    }

    public int bladenInOplossing(Oplossing oplossing) {
        BitSet selectie = oplossing.getSelectie();

        int bladen = 0;
        for (int i = selectie.nextSetBit(0); i >= 0; i = selectie.nextSetBit(i + 1)) {
            bladen += dossiers.get(i).getBladCount();
        }

        return bladen;
    }

    private int uniekeMeldingenInOplossing(Oplossing oplossing) {
        BitSet selectie = oplossing.getSelectie();

        BitSet meldingen = new BitSet();
        for (int i = selectie.nextSetBit(0); i >= 0; i = selectie.nextSetBit(i + 1)) {
            meldingen.or(dossiers.get(i).getMeldingen());
        }

        return meldingen.cardinality();
    }

    public void addDossier(Dossier dossier) {
        dossiers.add(dossier);
    }

    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public boolean isGeldigeOplossing(Oplossing oplossing) {
        return totaalMeldingen == uniekeMeldingenInOplossing(oplossing);
    }
}
