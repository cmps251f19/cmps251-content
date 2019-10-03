package _02.map.filter;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Given the values, double the even numbers and total.
    int result = 0;
    
    for(int e : numbers) {
      if(e % 2 == 0) {
        result += e * 2;
      }
    }
    
    
    
    System.out.println(result);
    
    result = numbers.stream().filter(e -> e % 2 == 0 && e > 4)
    				 //.filter(e -> e > 4)
    				 .map(e -> e * 2)
    				 .reduce(1, (product, e) -> product * e);
    
    //List<Integer> doubledEvens = results.collect(Collectors.toList());
    //System.out.println(doubledEvens);
    //results.forEach(System.out::println);
    //result = results.reduce(0, (sum, e) -> sum + e);
    
    System.out.println(result);
    
    result = numbers.stream()
				    .filter(e -> e % 2 == 0)
				    .mapToInt(e -> e * 2)
				    .sum();
    
    System.out.println(result);
  }
}