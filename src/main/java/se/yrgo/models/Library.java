package se.yrgo.models;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Library {

    private List<Book> library = new ArrayList<>();

    public List<Book> getLibrary() {
        return Collections.unmodifiableList(library);
    }

    public void addBook(Book book) throws IOException {
        for (Book b : library) {
            if (b.getIsbn().equals(book.getIsbn())) {
                System.out.println("Book already exists.");
                return; // Avbryter metoden om ISBN redan finns
            }
        }
        library.add(book); // Lägg till boken endast om ingen matchande ISBN hittades
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/se/yrgo/utils/Books.txt",
                true))) {

            writer.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPages() + ","
                    + book.getGenre());
            writer.write("\n");

        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public void addBookFromFile() throws IOException {
        Path path = Path.of("src/main/java/se/yrgo/utils/Books.txt");
        Path absolut = path.toAbsolutePath();

        try (BufferedReader reader = Files.newBufferedReader(absolut)) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] indexes = line.split(",");
                int pages = Integer.parseInt(indexes[3]);

                // Indexes: ISBN, title, author, pages, genre.
                Book createBook = new Book(indexes[0], indexes[1], indexes[2], pages, indexes[4]);

                library.add(createBook);
            }

        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public void removeBook(String isbn) {
        for (Book b : library) {
            if (b.getIsbn().equals(isbn)) {
                library.remove(b);
                System.out.println("Book successfully deleted.");
            } else {
                System.out.println("Could not delete book.");
            }
        }
    }
}
