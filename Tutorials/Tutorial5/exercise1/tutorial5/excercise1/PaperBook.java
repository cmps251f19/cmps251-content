package tutorial5.excercise1;

public class PaperBook extends Book {
    
    private String publisher;
    
    private String isbn;
        
    public PaperBook(String bookName, String author, int yearOfPublication, String publisher, String isbn){
        super(bookName,author,yearOfPublication);
        this.publisher = publisher;
        this.isbn = isbn;
    }
    
    @Override
    public String toString(){
        return String.format("%s\nPublisher - %s\nISBN - %s",super.toString(),publisher,isbn);
    }
    
}
