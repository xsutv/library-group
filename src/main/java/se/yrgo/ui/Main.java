package se.yrgo.ui;

import java.io.*;
import java.util.*;

import se.yrgo.models.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Library lib = new Library();

        List<Book> library = new ArrayList<>(List.of(
                new Book("9780008511685", "Butter", "Asako Yuzuki", 450, "null"),
                new Book("9781405950084", "Black Cake", "Charmaine Wikerson", 432, "null"),
                new Book("9781784700447", "The Memory Police", "Yoko Ogawa", 288, "null"),
                new Book("9781529029581", "Before the Coffee Gets Cold", "Toshikazu Kawaguchi", 224, "null"),
                new Book("1529050863", "Tales from the Cafe", "Toshikazu Kawaguchi", 256, "null"),
                new Book("123", "null", "null", 4, "null")));

        Book bok = new Book("123", "null", "null", 4, "null");
        Book bok1 = new Book("123", "null", "null", 4, "null");

        for (Book b : library) {
            lib.addBook(b);
        }

        lib.addBook(bok);
        lib.addBook(bok1);

        lib.addBookFromFile();

        for (Book b : lib.getLibrary()) {
            System.out.println(b);
        }
    }
}