package quLibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryUI {
    public static void main (String[] args)  
    { 
        // Creating the Objects of Book class. 
        Book b1 = new Book("Effective Java", "Joshua Bloch"); 
        Book b2 = new Book("Thinking in Java", "Bruce Eckel"); 
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt"); 
          
        // Creating the list which contains the books. 
        List<Book> books = new ArrayList<>(); 
        books.add(b1); 
        books.add(b2); 
        books.add(b3); 
          
        Library library = new Library(books); 
          
        books = library.getBooks(); 
        for(Book book : books){ 
            System.out.println("Title : " + book.getTitle() + " and " 
            		+" Author : " + book.getAuthor()); 
        }
    }
}
