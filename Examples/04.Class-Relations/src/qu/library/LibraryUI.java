package qu.library;

import java.util.List;

public class LibraryUI {
    public static void main (String[] args)  
    { 
    	Library library = new Library();
    	 
        // Creating the Objects of Book class. 
        Book book = new Book("Effective Java", "Joshua Bloch"); 
        library.addBook(book);
        
        book = new Book("Thinking in Java", "Bruce Eckel"); 
        library.addBook(book);
        
        book = new Book("Java: The Complete Reference", "Herbert Schildt"); 
        library.addBook(book);

        List<Book> books = library.getBooks(); 
        for(Book b : books){ 
            System.out.println(b); 
        }
    }
}
