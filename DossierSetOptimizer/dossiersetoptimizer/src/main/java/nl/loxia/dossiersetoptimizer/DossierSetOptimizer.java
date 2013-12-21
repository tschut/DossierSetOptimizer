package nl.loxia.dossiersetoptimizer;

import java.util.Arrays;

public class DossierSetOptimizer {
    public static void main(String[] args) {
        Probleem probleem = new Probleem();
        probleem.addDossier(new Dossier("een", Arrays.asList("a", "b"), 3));
        probleem.addDossier(new Dossier("twee", Arrays.asList("c", "b"), 2));
        probleem.addDossier(new Dossier("drie", Arrays.asList("a"), 1));

        Algoritme algoritme = new Algoritme(probleem);
    }
}
