package se.yrgo.ui;

import java.io.*;
import java.util.*;
import se.yrgo.models.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // visa vem du är inloggad som en användare
        // loan book
        // add review






        // Library tests::::

        Library lib = new Library();

        // List<Book> library = new ArrayList<>();

        List<Book> library = new ArrayList<>(List.of(
                new Book("9780008511685", "Butter", "Asako Yuzuki", 450, "null"),
                new Book("9781405950084", "Black Cake", "Charmaine Wikerson", 432, "null"),
                new Book("9781784700447", "The Memory Police", "Yoko Ogawa", 288, "null"),
                new Book("9781529029581", "Before the Coffee Gets Cold", "Toshikazu Kawaguchi", 224, "null"),
                new Book("1529050863", "Tales from the Cafe", "Toshikazu Kawaguchi", 256, "null"),
                new Book("null", "null", "null", 4, "null")));

        try {

            for (Book b : library) {
                lib.addBook(b);
            }

            Book test = new Book("test", "test", "test", 55, "test");

            lib.addBook(test);

            // This loop goes through our library win locally added books, and uses each
            // book with the given method.
            // If the book ISBN doesn't exists in our Books.txt, it gets added. Otherwise it
            // will not
            for (Book b : library) {
                lib.addBookFromListToFile(b);
            }

            lib.addBookFromFileToList();

            for (Book b : lib.getLib()) {
                System.out.println(b);
            }

            lib.removeBook("null");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}