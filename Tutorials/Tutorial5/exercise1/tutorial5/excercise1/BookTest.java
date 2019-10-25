package tutorial5.excercise1;

public class BookTest {
    public static void main(String[] args){
       
        PaperBook paperBook = new PaperBook("Absolute Java", "Deitel", 2017, "Pearson Publication", "B1243343-34234");
        
        System.out.println("Paper Book Details");
        System.out.println();
        
        System.out.println(paperBook.toString());
        
        System.out.println();
        System.out.println();
        
        AudioBook audioBook = new AudioBook("Absolute Java", "Deitel", 2017, 150, 90,"Peter Park");
        
        System.out.println("Audio Book Details");
        System.out.println();
        
        System.out.println(audioBook.toString());
        System.out.println();
        
    }
    
}
