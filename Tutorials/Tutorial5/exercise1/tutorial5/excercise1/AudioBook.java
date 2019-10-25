package tutorial5.excercise1;

public class AudioBook extends Book {
    
    private int size;
    
    private int length;
    
    private String artistName;
    
    public AudioBook(String bookName, String author, int yearOfPublication, int size, int length, String artistName){
        super(bookName,author,yearOfPublication);
        this.size = size;
        this.length = length;
        this.artistName = artistName;
    }
    
    @Override
    public String toString(){
        return String.format("%s\nSize - %d MB\nLength - %d mins\nArtist name - %s\n",super.toString(),size, length,artistName);
    }
    
}
