package se.yrgo.models;

public class Book {

    private String author;
    private String title;
    private String isbn;
    private String genre; // change this to an enum later.
    private int pages;

    public Book(String isbn, String title, String author, int pages, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        // this.review = tryParseInt(review);
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

    @Override
    public String toString() {
        return "Author: " + author + " Title: " + title + " ISBN: " + isbn + " Pages: " + pages + " Genre: "
                + genre + "\n";
    }

}


