package nl.loxia.dossiersetoptimizer;

import java.util.Arrays;

public class DossierSetOptimizer {
    public static void main(String[] args) {
        Probleem probleem = new Probleem();
        probleem.addDossier(new Dossier("een", Arrays.asList(1, 2), 3));
        probleem.addDossier(new Dossier("twee", Arrays.asList(3, 2), 2));
        probleem.addDossier(new Dossier("drie", Arrays.asList(1), 1));

        Algoritme algoritme = new Algoritme(probleem);
    }
}
