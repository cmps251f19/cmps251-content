package _05.findfirst;
import java.util.List;
import java.util.Optional;

public class Example1 {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    
    //given a list find the double of the first even number greater than 3.
    int result = 0;
    for(int e : numbers) {
      if(e > 3 && e % 2 == 0) {
        result = e * 2;
        break;
      }
    }
    System.out.printf("The double of the first even number greater than 3: %d", result);
    
    Optional<Integer> answer = numbers.stream()
									  .filter(e -> e > 300 && e % 2 == 0)
									  .map(e -> e * 2)
									  .findFirst();

    // if the stream is empty, an empty Optional is returned. 
    if (answer.isPresent()) { 
    	System.out.printf("\nThe double of the first even number greater than 3: %d", answer.get());
    } 
    else { 
        System.out.println("\nno value"); 
    } 
    
    int myNum = numbers.stream()
			  .filter(e -> e > 300 && e % 2 == 0)
			  .map(e -> e * 2)
			  .findFirst().orElse(0);

  }
}