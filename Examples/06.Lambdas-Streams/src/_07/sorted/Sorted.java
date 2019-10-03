package _07.sorted;
import java.util.Comparator;
import java.util.List;

public class Sorted {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(8, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .sorted()
           //.sorted(Comparator.reverseOrder())
           .forEach(System.out::println);
  }
}