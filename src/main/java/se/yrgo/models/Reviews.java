package se.yrgo.models;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Reviews {
    private List<Review> reviews = new ArrayList<>();

    private void readReviews() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/java/se/yrgo/utils/Reviews.txt"))) {
            String line;
            String isbn;
            String comment;
            String review;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                isbn = parts[0];
                comment = parts[1];
                review = parts[2];

                reviews.add(new Review(isbn, comment, review));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addReview(String isbn, String comment, String review) {
        String line = isbn.trim().toString() + " " + comment.toString() + " " + review.toString();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/java/se/yrgo/utils/Reviews.txt", true))) {
            writer.newLine();
            writer.write(line);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Reviews reviews = new Reviews();
        reviews.readReviews();
        reviews.addReview("9780307387899", "Goodie bookie", "4");
    }
}
