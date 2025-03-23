import java.io.*;
import java.util.*;

/**
 * The Kana_Data class is responsible for loading and managing Kana data
 * from a CSV file. It provides a list of Kana entries that can be used
 * in the Kana Quiz application.
 */
public class Kana_Data {
    private static final String FILE_PATH = "data/kana_romaji.csv";
    private List<String[]> kanaList = new ArrayList<>();

    /**
     * Constructor that initializes the Kana data by loading it from the CSV file.
     */
    public Kana_Data() {
        loadKanaData();
    }

    /**
     * Loads Kana data from the CSV file and populates the kanaList.
     * Each entry in the CSV file is split into an array of strings and added to the list.
     * Only entries with exactly 3 columns are considered valid.
     */
    private void loadKanaData() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    kanaList.add(parts);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading Kana data: " + e.getMessage());
        }
    }

    /**
     * Returns the list of Kana data entries.
     *
     * @return A list of Kana data entries, where each entry is an array of strings.
     */
    public List<String[]> getKanaList() {
        return kanaList;
    }
}
