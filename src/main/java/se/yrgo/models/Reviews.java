package se.yrgo.models;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Map.*;

public class Reviews {
    private HashMap<String, List<String>> reviewsMap = new HashMap<>();

    private void readReviews() {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/main/java/se/yrgo/utils/Reviews.txt"))) {
            String line;
            String isbn;
            String comment;
            String review;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" , ");
                isbn = parts[0];
                comment = parts[1];
                review = parts[2];

                String reviewLine = isbn.trim().toString() + " " + comment.toString() + " " + review.toString();

                reviewsMap.putIfAbsent(isbn, new ArrayList<>());
                reviewsMap.get(isbn).add(reviewLine);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addReview(String isbn, String comment, String review) throws IOException {
        String line = isbn.trim().toString() + " , " + comment.toString() + " , " + review.toString();

        if (review.toString() == "" || isbn.trim().toString() == "") {
            throw new IOException("No review found!");
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("src/main/java/se/yrgo/utils/Reviews.txt", true))) {
            writer.newLine();
            writer.write(line);
            reviewsMap.putIfAbsent(isbn, new ArrayList<>());
            reviewsMap.get(isbn).add(line);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public int getAllReviewsAmount() {
        int count = 0;
        for (Entry<String, List<String>> review : reviewsMap.entrySet()) {
            count += review.getValue().size();
        }
        return count;
    }

    // public static void main(String[] args) {
    // Reviews reviews = new Reviews();
    // reviews.addReview("9780307387899", "Goodie bookie", "4");
    // reviews.readReviews();

    // System.out.println(reviews.getAllReviewsAmount());

    // }
}
