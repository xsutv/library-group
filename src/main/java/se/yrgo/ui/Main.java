package se.yrgo.ui;

import java.io.*;
import java.util.*;

import se.yrgo.models.*;

public class Main {
    private static Library library = new Library();
    private static Book book;

    private static void addBookFunctionality() {
        String isbn = "";
        String title = "";
        String author = "";
        String genre = "";
        int page = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        i == 1 ? "Enter isbn: "
                                : i == 2 ? "Enter title: "
                                        : i == 3 ? "Enter author"
                                                : i == 4 ? "Enter genre" : i == 5 ? "Enter page" : null);

                if (i == 1) {
                    isbn = scanner.nextLine();
                } else if (i == 2) {
                    title = scanner.nextLine();
                } else if (i == 3) {
                    author = scanner.nextLine();
                } else if (i == 4) {
                    genre = scanner.nextLine();
                } else if (i == 5) {
                    page = scanner.nextInt();
                } else {
                    return;
                }
            }
            book = new Book(isbn, title, author, page, genre);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // add book
        // loan book
        // add review

        List<String> options = new ArrayList<>(List.of("Add book", "Rent book", "Add book review"));

        User loggedInUser = new User("123abc", "Björn", "Järnsida", "Kattigatt 37", "getgood@outlook.com");

        System.out.println("You're logged in as: " + loggedInUser.getName() + " " + loggedInUser.getLastName());

        System.out.printf("%nEnter number of what you want to do: %n");

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        try (Scanner scanner = new Scanner(System.in)) {
            switch (scanner.nextLine()) {
                case "1":
                    addBookFunctionality();
                    library.addBook(book);
                    System.out.println(book);
                    break;
                case "2":

                    break;
                case "3":

                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}