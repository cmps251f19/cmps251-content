package _06.sorted;
import java.util.List;

public class TestSorted {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(8, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .sorted()
           .forEach(System.out::println);
  }
}