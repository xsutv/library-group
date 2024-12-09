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

    public static void main(String[] args) {
        Reviews reviews = new Reviews();
        reviews.readReviews();
    }
}
