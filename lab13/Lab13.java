package Lab13;

import java.util.*;
import java.io.*;

public class Lab13 {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Enter file and element to search");
            return;
        }

        String thisLine;
        ArrayList<String> list = new ArrayList<>();
        BufferedReader fin = null;

        try {
            fin = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

            while ((thisLine = fin.readLine()) != null) {
                System.out.println("Input:" + thisLine);
                list.add(thisLine);
            }

            Collections.sort(list);

            System.out.println("Sorted list:");
            Iterator<String> iter = list.iterator();

            while (iter.hasNext()) {
                String str = iter.next();
                System.out.println(str);
            }

            String searchString = args[1];
            int searchResult = Collections.binarySearch(list, searchString);

            if (searchResult >= 0) {
                System.out.println("Line '" + searchString + "' finded on position " + searchResult);
            } else {
                System.out.println("Line '" + searchString + "' not findet");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File doesn`t exists: " + args[0]);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Input error " + args[0]);
            System.out.println("Error: " + e);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException ex) {
                    System.out.println("File close error " + args[0]);
                    System.out.println("Error: " + ex);
                }
                fin = null;
            }
        }
    }
}
