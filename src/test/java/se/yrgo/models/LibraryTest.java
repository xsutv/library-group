// package se.yrgo.models;

// import static org.junit.jupiter.api.Assertions.*;
// import java.util.*;
// import org.junit.jupiter.api.*;

// /**
//  * Testing some of the methods in library. 
//  * 
//  * @author Haimen Abbas - xstuv @ GitHub
//  */

// public class LibraryTest {

//     private Library lib;

//     Book book = new Book("9781784700447", "The Memory Police", "Yoko Ogawa", 288, "null");


//     public LibraryTest () {
//         lib = new Library();

//     }

//     @Test
//     public void removeBookTest() {
//         lib.addBook(book);
//         lib.removeBook("9781784700447");
//     }
    
//     @Test
//     public void addBookTest() {
//         lib.addBook(book);
//         assertEquals(1, lib.getLibrarySize());
//     }

//     @Test
//     public void findBookTest() {
//         lib.addBook(book);
//         assertEquals(book, lib.searchBook(book.getIsbn()));
//         }


    
//     @Test // This test should throw NoSuchElementException.
//     public void bookDoesntExistsTest() {
//         lib.addBook(book);
//         assertThrows(NoSuchElementException.class, () -> lib.searchBook("978184700447"));
//     }


// }
