package se.yrgo.models;

import java.time.*;
import java.util.*;

public class Loan {
    private String isbn;
    private static Map<String, String> loanList = new HashMap<>();

    public static Map<String, String> getLoanList() {
        return loanList;
    }

    public Loan(Book book) {
        this.isbn = book.getIsbn();
    }

    public String getIsbn() {
        return isbn;
    }

    /**
     * 
     * @author Viggo Nielsen
     *         Functions as the main hub of the class. This is where every other
     *         method is used.
     *         This method also adds the books isbn and user to a map containing
     *         whos currently borrowing the book and the book itself
     * @param lib  - the library classes member variable that is a list
     * @param isbn - the books string member variable that represents the books isbn
     * @param user - the user.
     */
    public static void loanBook(List<Book> lib, String isbn, User user) {
        isbn = findIsbn(lib, isbn);
        if (isbn == null) {
            return;
        }
        String userID = user.getUserID();
        if (checkLoanStatus(isbn, user) == true) {
            loanList.put(isbn, userID);
            System.out.println("return book before: " + returnDate());
        } else {
            System.err.println("Book is already borrowed");
        }

    }

    /**
     * @author Viggo Nielsen
     *         checks the library list brought along in the loanBook method to see
     *         if the book the user wants to borrow even exists
     * @param lib  - the library member variable that is a list of books available
     * @param isbn - the books isbn
     * @return - returns null if the book doesnt exist. Otherwise it returns with
     *         the isbn and the loan process continues.
     */
    private static String findIsbn(List<Book> lib, String isbn) {
        for (Book i : lib) {
            System.out.println(i);
            if (i.getIsbn().equals(isbn)) {
                return isbn;
            } else {
                continue;
            }

        }
        System.err.println("The ISBN of the book you want to rent does not exist");
        return null;
    }

    /**
     * @author Viggo Nielsen
     *         a method that checks if the book is currently borrowed. If it is it
     *         will return false, if its not it will return true.
     * @param isbn - the isbn of the book
     * @param user - user who wants to borrow the book
     * @return - returns true if the book is free or false if the book is already
     *         borrowed.
     */
    public static boolean checkLoanStatus(String isbn, User user) {
        if (loanList.containsKey(isbn)) {
            return false;
        } else {
            System.out.println("The Book is free");
            return true;
        }

    }

    /**
     * @author Viggo Nielsen
     *         decides when the book is to be returned by creating a LocalDate
     *         object of teh current date plus 3 weeks (21 days)
     * @return - returns the date the book is to be returned
     */
    private static LocalDate returnDate() {
        LocalDate returnDate = LocalDate.now().plusDays(21);
        return returnDate;

    }
}
