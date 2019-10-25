package tutorial5.excercise1;

public class Book {
    
    private String name;
    
    private String author;
    
    private int yearOfPublication;
    
    public Book(String name, String author, int yearOfPublication){
        this.name = name;
        this.author =author;
        this.yearOfPublication = yearOfPublication;
    }
    
    @Override
    public String toString(){
        return String.format("Name - %s\nAuthor - %s\nYear Of Publication - %d",name,author, yearOfPublication);
    }
    
}
