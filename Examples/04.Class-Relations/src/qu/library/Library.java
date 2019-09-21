package qu.library;

import java.util.ArrayList;
import java.util.List;

class Library  
{ 
    private final List<Book> books; 
    
    Library () { 
        this.books = new ArrayList<>(); 
    } 
    
    public void addBook(Book book) {
    	books.add(book);
    }
    
    public List<Book> getBooks(){ 
       return books;   
    } 
} 