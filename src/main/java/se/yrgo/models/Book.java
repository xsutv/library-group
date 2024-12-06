package se.yrgo.models;

public class Book {

    private String author;
    private String title;
    private String isbn;
    private String genre; // change this to an enum later.
    private int pages;

    public Book(String author, String title, String isbn, String genre, int pages) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
        this.pages = pages;
    }


    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getGenre() {
        return genre;
    }
    public int getPages() {
        return pages;
    }


    
    
    
}
