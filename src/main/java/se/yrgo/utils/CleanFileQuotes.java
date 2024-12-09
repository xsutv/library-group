package se.yrgo.utils;
import java.io.*;
import java.util.regex.*;

public class CleanFileQuotes {
    public static void cleanFile(String inputFilePath, String outputFilePath) {
        // Regex to match and remove the empty quotes
        String regex = "\",\\s*\"\"\\s*,";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Replace empty quotes using regex
                String cleanedLine = pattern.matcher(line).replaceAll(",");
                // Write the cleaned line to the output file
                writer.write(cleanedLine);
                writer.newLine();
            }
            System.out.println("File cleaned and saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        String inputFilePath = "Top100Books_Full.txt"; // Path to the input file
        String outputFilePath = "Books.txt"; // Path to the output file

        cleanFile(inputFilePath, outputFilePath);
    }
}