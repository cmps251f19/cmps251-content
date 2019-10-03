package _06.distinct;
import java.util.List;

public class Distinct {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    //Distinct even numbers
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .distinct()
           .forEach(System.out::println);
  }
}