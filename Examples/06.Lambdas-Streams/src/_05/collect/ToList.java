package _05.collect;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; 

public class ToList {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    //Filter the even values and put them into a list.
    
    //Not the best way to do this.
    List<Integer> evens = new ArrayList<>();
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .forEach(e -> evens.add(e));
    
    System.out.println(evens);
    
    //Use .distinct() // To remove duplicates
    List<Integer> evens2 =
      numbers.stream()
             .filter(e -> e % 2 == 0)
             //.distinct() 
             .collect(Collectors.toList());
    
    System.out.println(evens2);
    
    String evenNums = numbers.stream()
		    	             .filter(e -> e % 2 == 0)
		    	             .map(String::valueOf)
		    	             .collect(Collectors.joining(", "));
    	    
    System.out.println(evenNums);
  }
}