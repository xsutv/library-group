package se.yrgo.models;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Map.*;

public class Reviews {
    private HashMap<String, List<String>> reviewsMap = new HashMap<>();

    /**
     * this method reads each review from Reviews.txt and inserts it to local
     * HashMap
     * 
     * @author Fia
     */
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

    /**
     * 
     * @param isbn    id - isbn of reviewd book
     * @param comment the actual review comment written by user
     * @param review  a review from 1-5
     * @throws IOException if review is empty
     * @author Fia
     */
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

    /**
     * @return count of all reviews from all books
     * @author Fia
     */
    public int getAllReviewsAmount() {
        int count = 0;
        for (Entry<String, List<String>> review : reviewsMap.entrySet()) {
            count += review.getValue().size();
        }
        return count;
    }
}
