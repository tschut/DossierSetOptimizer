package nl.loxia.dossiersetoptimizer;


public class DossierSetOptimizer {
    public static void main(String[] args) {
        Probleem probleem = new Probleem(InputParser.parse(args[0]));

        Algoritme algoritme = new Algoritme(probleem);
    }
}