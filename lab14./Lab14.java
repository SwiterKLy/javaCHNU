package Lab14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Lab14 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Input: " + line);

                List<String> tokens = tokenizeLine(line);
                System.out.print("The line consists of:");

                for (String token : tokens) {
                    System.out.print("\n" + token);

                    try {
                        double number = Double.parseDouble(token);
                        System.out.print(" - it's a number = " + number);
                    } catch (NumberFormatException e) {
                        System.out.print(" - it's not a number");
                    }
                }
                System.out.println("\n");
            }
            reader.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> tokenizeLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                }
            } else {
                token.append(currentChar);
            }
        }

        if (token.length() > 0) {
            tokens.add(token.toString());
        }

        return tokens;
    }
}