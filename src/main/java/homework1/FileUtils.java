package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        reader.readLine(); // Skip header
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(";");
            Entry entry = new Entry(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            entries.add(entry);
        }
        reader.close();
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write("Name;Street Address;City;Postcode;Country;Phone Number\n");
        for (Entry entry : entries) {
            writer.write(entry.toString() + "\n");
        }
        writer.close();
    }
}
