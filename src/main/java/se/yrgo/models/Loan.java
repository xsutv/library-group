package se.yrgo.models;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Loan {
    private String isbn;
    private static Map<String, String> loanList = new HashMap<>();




    public Map<String, String> getLoanList() {
        return loanList;
    }




    public Loan(Book book){
        this.isbn = book.getIsbn();
    }




    public String getIsbn() {
        return isbn;
    } 

    

    public static void loanBook(Book book, User user){
        String isbn = book.getIsbn();
        String userID = user.getUserID();
        if(checkLoanStatus(isbn, user)==true){
            loanList.put(isbn, userID); 
            System.out.println("return book before: " + returnDate());
        }
        else{
            System.err.println("Book is already borrowed");
        }
        
        
        
    }
    public static boolean checkLoanStatus(String isbn, User user){
        
        if (loanList.containsKey(isbn)){
            return false; 
        }
        else{
            System.out.println("The Book is free");   
            return true;  
        }     
        
    }
    private static LocalDate returnDate(){
        LocalDate returnDate = LocalDate.now().plusDays(21);
        return returnDate; 
        
    }
}
    

