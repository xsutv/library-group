package se.yrgo.models;

import java.util.*;

public class Library {

    private Book book;

    private List<Book> library = new ArrayList<>();

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
