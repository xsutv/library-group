package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.*;

/**
 * Testing some of the methods in library.
 * 
 * @author Haimen Abbas - xstuv @ GitHub for all tests for this class.
 */

public class LibraryTest {

    private Library lib;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {

        lib = new Library();

        book1 = new Book("9781784700447", "The Memory Police", "Yoko Ogawa", 288, "null");
        book2 = new Book("9781529029581", "Before the Coffee Gets Cold", "Toshikazu Kawaguchi", 224, "null");
        book3 = new Book("fell", "", "", 0, "");

        lib.addBook(book1);
        lib.addBook(book2);

    }

    @Test
    public void testRemoveBookSuccess() throws IOException {
        assertTrue(lib.getLib().contains(book1));

        lib.removeBook("9781784700447");

        assertFalse(lib.getLib().contains(book1));
        assertEquals(1, lib.getLibrarySize());
    }

    @Test // This test should throw an IOException because book is not existing in
          // library.
    public void testRemoveBookNotFound() {
        assertThrows(IOException.class, () -> lib.removeBook("9999"));
    }

    @Test
    public void testAddBookSuccess() {
        lib.addBook(book3);
        assertEquals(3, lib.getLibrarySize());
    }

    @Test // This book should throw IllegalArgumentException.
    public void testAddBookNotFound() {
        assertThrows(IllegalArgumentException.class, () -> lib.addBook(book1));
    }

    @Test
    public void testSearchBookSuccess() {
        assertEquals(book1, lib.searchBook(book1.getIsbn()));
    }

    @Test // This test should throw NoSuchElementException because book with that isbn
          // doesnt exists.
    public void testSearchBookNotFound() {
        assertThrows(NoSuchElementException.class, () -> lib.searchBook("9999"));
    }

}
