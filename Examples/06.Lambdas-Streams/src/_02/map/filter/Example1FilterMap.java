package _02.map.filter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1FilterMap {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Given the values, double the even numbers and total.
    int result = 0;
    
    for(int e : numbers) {
      if(e % 2 == 0) {
        result += e * 2;
      }
    }

    System.out.printf("Total of doubled even numbers: %d %n", result);
    
    result = numbers.stream()
    				 .filter(e -> e % 2 == 0)
    				 .map(e -> e * 2)
    				 .reduce(0, (sum, e) -> sum + e);
    
    System.out.printf("Total of doubled even numbers: %d %n", result);
    
    result = numbers.stream()
				    .filter(e -> e % 2 == 0)
				    .mapToInt(e -> e * 2)
				    .sum();
    System.out.printf("Total of doubled even numbers: %d %n", result);
    
    // Concatenation of strings using reduce
    /* "" is the starter (identity) value. It is combined with the first entry in the Stream.
       String::concat is the same as (s1, s2) -> s1 + s2.
    	It concatenates the seed value with the first Stream entry,
    	concatenates that resultant String with the second Stream entry,
    	and so forth.
    */
    List<String> letters = List.of("J", "a", "v", "a");
    String concat = letters.stream().reduce("", String::concat);
    System.out.printf("Concatenation of %s is %s.%n", letters, concat);
    
    //List<Integer> doubledEvens = results.collect(Collectors.toList());
    //System.out.println(doubledEvens);
    //results.forEach(System.out::println);
    //result = results.reduce(0, (sum, e) -> sum + e);
  }
}