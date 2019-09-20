package qu.library;

import java.util.List;

class Library  
{ 
    // reference to refer to list of books. 
    private final List<Book> books; 
      
    Library (List<Book> books) 
    { 
        this.books = books;  
    } 
      
    public List<Book> getBooks(){ 
       return books;   
    } 
      
} 