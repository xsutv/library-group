package se.yrgo.models;

import java.util.*;

public class Library {
    
    Book book;
    private List<Book> library = new ArrayList<>();

    public void addBook(Book book) {
        for (Book b : library) {
            if (b.getIsbn().equals(book.getIsbn())) {
                System.out.println("Book already exists.");
            } else {
                library.add(book);
            }
        }
    }

    

}
