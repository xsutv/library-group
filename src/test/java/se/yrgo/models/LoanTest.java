package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoanTest {
    private Library lib = new Library();
    private String isbn;

    private Book book1 = new Book("9789113084909", "Ringens brödraskap", "J R R Tolkien", 528, "fantasy");
    private User user1 = new User("1234", "viggo", "nielsen", "trumpetvägen 12", "viggo@gmail.com");
    private User user2 = new User("5678", "Qbert", "jansson", "vikingagatan 15", "qbert@outlook.com");


    @Test
    public void testLoanBook() {
        isbn = "9789113084909";
        lib.addBook(book1);
        Loan.loanBook(lib.getLib(), isbn, user1);
        assertTrue(
                Loan.getLoanList().containsKey(book1.getIsbn()) && Loan.getLoanList().containsValue(user1.getUserID()));

    }

    @Test
    public void testCheckLoanStatus() {
        // true = book not borrowed
        Loan.loanBook(lib.getLib(), isbn, user1);
        assertTrue(Loan.checkLoanStatus(book1.getIsbn(), user1));
    }

}
