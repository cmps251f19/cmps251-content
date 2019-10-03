package _02.map.sum;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Sample {
  public static void main(String[] args) {
	Stream<Integer> numsStream = Stream.of(10, 30, 40, 60);
	numsStream.forEach(e -> System.out.println(e));
	  
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Given the values, double the even numbers and total.
    int result = 0;
    
    for(int e : numbers) {
      if(e % 2 == 0) {
        result += e * 2;
      }
    }
    
    System.out.println(result);
    
    result = numbers.stream()
    	             .filter(e -> e % 2 == 0)
    	             .map(e -> e * 2)
    	             .reduce(0, (sum, e) -> sum + e);
    
    System.out.println(result);
    
    result = numbers.stream().parallel()
				    .filter(e -> e % 2 == 0)
				    .mapToInt(e -> e * 2)
				    .sum();
    
    System.out.println(result);
  }
}