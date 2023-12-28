package Lab15;

import java.io.File;
import java.util.Scanner;

public class Lab15 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter the directory name for file deletion.");
            return;
        }

        String directoryName = args[0];
        File directory = new File(directoryName);

        if (!directory.isDirectory()) {
            System.out.println("The directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("The directory is empty.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Warning! Delete " + files.length + " files in the directory " + directoryName + "? (Y/N)");
        String confirmation = scanner.next();

        if (confirmation.equalsIgnoreCase("Y")) {
            for (File file : files) {
                if (file.delete()) {
                    System.out.println("File " + file.getName() + " deleted.");
                } else {
                    System.out.println("Error deleting file " + file.getName());
                }
            }
        } else {
            System.out.println("File deletion operation cancelled.");
        }
        scanner.close();
    }
}