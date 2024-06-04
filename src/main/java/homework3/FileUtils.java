package homework3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileUtils {
    public static RedBlackTree readFile(String filePath) throws FileNotFoundException {
        // implement the actual logic (remove next line)
        RedBlackTree tree = new RedBlackTree();
        Scanner scanner = new Scanner(new FileReader(filePath));
        boolean isFirstLine = true;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (isFirstLine) {
                isFirstLine = false;
                continue;
            }
            if (line.isEmpty()) continue;

            String[] data = line.split(";");
            if (data.length != 6) {
                System.out.println("Invalid line skipped: " + line);
                continue;
            }

            String[] nameParts = data[0].split(", ");
            if (nameParts.length != 2) {
                System.out.println("Invalid name field: " + data[0]);
                continue;
            }
            String surname = nameParts[0];
            String name = nameParts[1];

            Entry entry = new Entry(surname, name, data[1], data[2], data[3], data[4], data[5]);
            tree.put(surname + ", " + name, entry);
        }
        scanner.close();
        return tree;

    }
}



