package nl.loxia.dossiersetoptimizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public static List<Dossier> parse(String fileName) {
        List<Dossier> result = new ArrayList<Dossier>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            reader.readLine(); // skip header
            for (String line; (line = reader.readLine()) != null;) {
                result.add(processLine(line));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static Dossier processLine(String line) {
        String[] split = line.split(";");

        String naam = split[0];
        int bladCount = Integer.parseInt(split[1]);
        List<Integer> meldingen = new ArrayList<Integer>();

        for (int i = 2; i < split.length; ++i) {
            if (!split[i].isEmpty()) {
                meldingen.add(i);
            }
        }

        return new Dossier(naam, meldingen, bladCount);
    }
}
