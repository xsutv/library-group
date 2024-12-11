package se.yrgo.models;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Loan {
    private String isbn;
    private Map<String, String> loanList = new HashMap<>();




    public Loan(Book book){
        this.isbn = book.getIsbn();
    }




    public String getIsbn() {
        return isbn;
    } 

    public void loanBook(){
        
        
    }
    public void checkLoanStatus(Book book, User user){
        loanList.put(isbn, user.getUserID());
        if (loanList.containsKey(isbn) && loanList.containsValue(user.getUserID())){
            System.err.println("Book is already borrowed ");
        }
        else{
            System.out.println("The Book is free");
            System.out.println("return the book before: " + returnDate());
            
        }     
        
    }
    private LocalDate returnDate(){
        LocalDate returnDate = LocalDate.now().plusDays(21);
        return returnDate; 
        
    }
}
    

