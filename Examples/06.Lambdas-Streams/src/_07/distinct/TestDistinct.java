package _07.distinct;
import java.util.List;

public class TestDistinct {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .distinct()
           .forEach(System.out::println);
  }
}