package se.yrgo.ui;

import java.io.*;
import java.util.*;

import se.yrgo.models.*;

public class Main {
    private static Reviews review = new Reviews();
    private static Library library = new Library();
    private static Book book;

    private static void addBookFunctionality(Scanner scanner) {
        String isbn = "";
        String title = "";
        String author = "";
        String genre = "";
        int page = 0;

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        i == 1 ? "Enter isbn: "
                                : i == 2 ? "Enter title: "
                                        : i == 3 ? "Enter author: "
                                                : i == 4 ? "Enter genre: " : "Enter page: ");

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
                    scanner.nextLine(); // Consume leftover newline
                }
            }
            book = new Book(isbn, title, author, page, genre);

            library.addBook(book);
            library.addBookFromListToFile(book);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void addUserReview(Scanner scanner) {

        try {

            System.out.println("Specify the ISBN of the book you want to review: ");
            String isbn = scanner.nextLine().trim();

            System.out.println("Comment: (frivilligt)");
            String comment = scanner.nextLine().trim();

            System.out.println("Rate the book 1-5: ");
            String rating = scanner.nextLine().trim();

            review.addReview(isbn, comment, rating);

            System.out.println("Thank you for your review!");

        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    private static void rentBook(Scanner input, Library lib, User user) {
        System.out.println("Write the ISBN of the book you want to borrow:");
        String bookIsbn = input.nextLine();
        Loan.loanBook(library.getLib(), bookIsbn, user);

    }

    public static void main(String[] args) throws IOException {

        String input = "";

        List<String> options = new ArrayList<>(List.of("Add book", "Rent book", "Add book review"));

        User loggedInUser = new User("123abc", "Björn", "Järnsida", "Kattigatt 37", "getgood@outlook.com");

        try (Scanner scanner = new Scanner(System.in)) {

            do {
                System.out.println("You're logged in as: " + loggedInUser.getName() + " " + loggedInUser.getLastName());

                System.out.printf("%nEnter number of what you want to do: %n(Enter X to exit)%n");

                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }

                input = scanner.nextLine();

                switch (input) {
                    case "1":
                        addBookFunctionality(scanner);
                        break;
                    case "2":
                        rentBook(scanner, library, loggedInUser);
                        break;
                    case "3":
                        addUserReview(scanner);
                        break;
                    default:
                        break;
                }

            } while (!input.equalsIgnoreCase("x"));
        }
    }
}
