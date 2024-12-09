package se.yrgo.models;

public class Book {

    private String author;
    private String title;
    private String isbn;
    private String genre; // change this to an enum later.
    private int pages;
    private int review;

    private int tryParseInt(String review) {
        try {
            return Integer.parseInt(review);
        } catch (Exception e) {
            System.err.println(e);
            return 3;
        }
    }

    public Book(String isbn, String title, String author, String genre, int pages, String review) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.review = tryParseInt(review);
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
