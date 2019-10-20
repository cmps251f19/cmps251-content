package _05.collect;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; 

public class ToList {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    //Filter the even values, double them and put them into a list without duplicates
    List<Integer> evens = new ArrayList<>();
    for(int n : numbers) {
        if(n % 2 == 0) {
        	int doubled = n * 2;
        	if (!evens.contains(doubled))
        		evens.add(doubled);
        }
    }
    
    //Not the best way to do this.
	evens.clear();    	
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .map(e -> e * 2)
           .forEach(e -> evens.add(e));
    
    System.out.println(evens);
    
    //Use .distinct() // To remove duplicates
    List<Integer> evens2 =
      numbers.stream()
             .filter(e -> e % 2 == 0)
             .map(e -> e * 2)
             .distinct() 
             .collect(Collectors.toList());
    
    System.out.println(evens2);
    
    String evenNums = numbers.stream()
		    	             .filter(e -> e % 2 == 0)
		    	             .map(String::valueOf)
		    	             .collect(Collectors.joining(", "));
    	    
    System.out.println(evenNums);
  }
}