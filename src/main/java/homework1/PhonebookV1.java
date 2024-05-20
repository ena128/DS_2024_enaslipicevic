package homework1;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath = "C:\\Users\\g1\\Downloads\\raw_phonebook_data.csv";
        String outputFilePath = "C:\\Users\\g1\\Downloads\\sorted.csv";

        try {

            Entry[] entries = FileUtils.readFile(inputFilePath);

            // Sort the array using merge sort
            MergeSort.sort(entries);

            // Save the sorted array to a new CSV file
            FileUtils.writeToFile(entries, outputFilePath);

            // Prompt user to search for a name
            while (true) {
                System.out.println("Enter a 'Name' to search for, or -1 to exit:");
                String input = scanner.nextLine();
                if (input.equals("-1")) {
                    break;
                }

                // Perform binary search on the sorted data array
                int[] result = BinarySearch.search(entries, input);

                // Print the result
                if (result.length == 0) {
                    System.out.println("No entries found for " + input);
                } else {
                    System.out.println("Found " + (result[1] - result[0] + 1) + " entries for " + input + ":");
                    for (int i = result[0]; i <= result[1]; i++) {
                        System.out.println(entries[i]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
