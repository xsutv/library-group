package se.yrgo.models;

public class Book {

    private String author;
    private String title;
    private String isbn;
    private String genre; // change this to an enum later.
    private int pages;

    public Book(String isbn, String author, String title, String genre, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
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
