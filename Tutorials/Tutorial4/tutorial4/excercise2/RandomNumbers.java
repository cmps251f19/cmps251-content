package tutorial4.excercise2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
 public static void main(String args[])
 {
	Random generator = new Random();
    IntStream randomStream = generator.ints(1, 999);
    
    //IntStream.boxed turns an IntStream into a Stream<Integer>, which you can then collect into a list:
    //theIntStream.boxed().collect(Collectors.toList())
    List<Integer> numbers = randomStream.limit(50).boxed().collect(Collectors.toList());
    
    System.out.println(numbers);
	System.out.printf("Number of odds =%s%n", numbers.stream().mapToInt(Integer::intValue).filter(value-> value %2==0).count());
	System.out.printf("Number of evens =%s%n", numbers.stream().mapToInt(Integer::intValue).filter(value-> value %2==1).count());
	System.out.printf("Average of odd =%s%n", numbers.stream().mapToInt(Integer::intValue).filter(value-> value %2==0).average().getAsDouble());
	System.out.printf("Average of evens =%s%n", numbers.stream().mapToInt(Integer::intValue).filter(value-> value %2==1).average().getAsDouble());
	System.out.printf("Average of all =%s%n", numbers.stream().mapToInt(Integer::intValue).average().getAsDouble());

 }
}
