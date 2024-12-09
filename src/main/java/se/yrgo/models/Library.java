package se.yrgo.models;

import java.util.*;

public class Library {

    private Book book;
    private List<Book> library = new ArrayList<>(List.of(new Book("9780008511685", "Butter", "Asako Yuzuki", "", 450),
            new Book("9781405950084", "Black Cake", "Charmaine Wikerson", "", 432),
            new Book("9781784700447", "The Memory Police", "Yoko Ogawa", "", 288),
            new Book("9781529029581", "Before the Coffee Gets Cold", "Toshikazu Kawaguchi", "", 224),
            new Book("1529050863", "Tales from the Cafe", "Toshikazu Kawaguchi", "", 256)));

    public void addBook(Book book) {
        for (Book b : library) {
            if (b.getIsbn().equals(this.book.getIsbn())) {
                System.out.println("Book already exists.");
            } else {
                library.add(this.book);
            }
        }
    }

}
