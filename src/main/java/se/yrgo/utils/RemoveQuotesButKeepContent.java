package se.yrgo.utils;

import java.io.*;


public class RemoveQuotesButKeepContent {
    public static void removeQuotesFromFile(String inputFilePath, String outputFilePath) {
        // Regex för att ta bort citationstecken från varje fält (t.ex., "The Kite
        // Runner" -> The Kite Runner)
        String regex = "\\s*,\\s*"; // Matchar kommatecken omgiven av valfritt antal mellanslag
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Ta bort eventuella extra mellanslag runt kommatecknen
                line = line.replaceAll(regex, ",");
                // Skriv den rensade raden till output-filen
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File converted to CSV format and saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exempelanvändning
        String inputFilePath = "Books.txt"; // Sökväg till inputfilen
        String outputFilePath = "Bookss.txt"; // Sökväg till outputfilen

        removeQuotesFromFile(inputFilePath, outputFilePath);
    }
}