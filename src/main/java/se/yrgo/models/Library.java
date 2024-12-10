package se.yrgo.models;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * This class acts as our whole library with methods related to some of the
 * things we might want to be able to do with a library.
 * 
 * 
 * @author [Haimen Abbas xzutv @Github]
 */

public class Library {

    private List<Book> lib = new ArrayList<>();

    // Standard Constructor.
    public Library() {
    }

    public List<Book> getLib() {
        return Collections.unmodifiableList(lib);
    }

    public int getLibrarySize() {
        return lib.size();
    }

    /**
     * This method takes a Book object as a parameter, if ISBN of the object already
     * exists in our Library, it throws an exception.
     * It also adds the book to our Books.txt file with our addBookToFile method.
     * 
     * 
     * @param book
     * @throws IllegalArgumentException - if book already exists in library.
     * @author [Haimen Abbas xzutv @Github]
     */

    public void addBook(Book book) {
        for (Book b : lib) {
            if (b.getIsbn().equals(book.getIsbn())) {
                throw new IllegalArgumentException("Book with the same ISBN already exists. " + b + " and " + book);
            }
        }
        lib.add(book);
    }

    /**
     * COMPLETE
     * This takes a Book object that exists in our List<Book> library as a parameter
     * A control is made of the ISBN of the given book, if it already exists in our
     * Books.txt, it will give an error and not add it.
     * 
     * @param book
     * @author [Haimen Abbas xzutv @Github]
     */

    public void addBookFromListToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/se/yrgo/utils/Books.txt",
                true));
                BufferedReader reader = Files.newBufferedReader(Path.of("src/main/java/se/yrgo/utils/Books.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String isbnInFile = parts[0];
                if (parts.length > 5) {
                    System.out.println("Malformed line in file " + line);
                    continue;
                }

                if (book.getIsbn().trim().equals(isbnInFile.trim())) {
                    System.out.println("This book already exists in file." + isbnInFile);
                    return;
                }
            }

            writer.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPages() + ","
                    + book.getGenre());
            writer.write("\n");

        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    /**
     * This method reads from a textfile called Books.txt and adds it to our
     * List<Books> Library.
     * 
     * @author [Haimen Abbas xzutv @Github]
     */

    public void addBookFromFileToList() {
        Path path = Path.of("src/main/java/se/yrgo/utils/Books.txt");
        Path absolut = path.toAbsolutePath();

        try (BufferedReader reader = Files.newBufferedReader(absolut)) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                int pages = Integer.parseInt(parts[3]);

                if (parts.length > 5) {
                    System.out.println("Malformed line in file " + line);
                    continue;
                }

                // Indexes: ISBN, title, author, pages, genre.
                Book createBook = new Book(parts[0], parts[1], parts[2], pages, parts[4]);

                addBook(createBook);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 
     * 
     * @param isbn
     * @throws IOException
     * @author [Haimen Abbas xzutv @Github]
     */

    public void removeBook(String isbn) throws IOException {
        boolean found = false;

        for (int i = 0; i < lib.size(); i++) {
            if (lib.get(i).getIsbn().equals(isbn)) {
                lib.remove(i);
                System.out.println("Book successfully deleted.");
                found = true;
                break; 
            }
        }

        if (!found) {
            throw new IOException("Could not find book");
        }

    }

    /**
     * 
     * @param isbn
     * @return true if book exists.
     * @author [Haimen Abbas xzutv @Github]
     */

    public Book searchBook(final String isbn) {
        return lib.stream().filter(s -> s.getIsbn().equals(isbn)).findAny().orElseThrow();
    }
}
