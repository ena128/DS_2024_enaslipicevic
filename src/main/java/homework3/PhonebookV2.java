package homework3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {

        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";



        Scanner scanner = new Scanner(System.in);
        RedBlackTree tree = null;
        try {
            tree = FileUtils.readFile("C:\\Users\\g1\\Downloads\\raw_phonebook_data (1).csv");
        } catch (FileNotFoundException e) {
            System.out.println("No file: " + e.getMessage());
            scanner.close();
            return;
        }
        System.out.println("\nLoading entities...");
        System.out.println("=============================================================");
        System.out.println("System is ready!.");




        int[] edgeCounts = tree.countRedAndBlackEdges();
        System.out.println("Total" +  RED + " red edges" + " in the tree: "+RESET + edgeCounts[1]);
        System.out.println("Total black edges in the tree: " + edgeCounts[0] + "\n");

        while (true) {
            System.out.print("Enter the name you want to to search (-1 to exit): ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                System.out.println("Thanks for using the phonebook. \n");
                break;
            }

            ArrayList<Entry> entries = tree.get(input);
            if(entries != null) {
                System.out.println("Entries found: " + entries.size() + "\n");
                for (Entry entry : entries) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("No entries with the name in phonebook. \n");
            }
        }

        scanner.close();
    }
}
