package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ReviewsTest {
    private Reviews reviews;

    public ReviewsTest() {
        reviews = new Reviews();
    }

    @Test
    public void testAddReview() {
        reviews.addReview("9780307387899", "Goodie bookie", "4");

        assertEquals(1, reviews.getAllReviewsAmount());
    }
}
