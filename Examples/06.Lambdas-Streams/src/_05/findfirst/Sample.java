package _05.findfirst;
import java.util.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    
    //given an ordered list find the double of the first even number greater than 3.
    
    int result = 0;
    for(int e : numbers) {
      if(e > 3 && e % 2 == 0) {
        result = e * 2;
        break;
      }
    }
    System.out.println(result);
    
    Optional<Integer> answer = numbers.stream()
									  .filter(e -> e > 3)
									  .filter(e -> e % 2 == 0)
									  .map(e -> e * 2)
									  .findFirst();

    // if the stream is empty, an empty Optional is returned. 
    if (answer.isPresent()) { 
        System.out.println(answer.get()); 
    } 
    else { 
        System.out.println("no value"); 
    } 
  }
}