package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

public class ReviewsTest {
    private Reviews reviews;

    public ReviewsTest() {
        reviews = new Reviews();
    }

    @Test
    /**
     * @author Fia
     */
    public void testAddReview() {
        try {
            reviews.addReview("9780307387899", "Goodie bookie", "4");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(1, reviews.getAllReviewsAmount());
    }

    @Test
    /**
     * @author Fia
     */
    public void testAddEmptyReview() throws IOException {
        assertThrows(IOException.class, () -> reviews.addReview("", "Comment", ""));
    }
}
