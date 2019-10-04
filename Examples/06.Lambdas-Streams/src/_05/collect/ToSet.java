package _05.collect;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors; 

public class ToSet {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    //double the even values and put that into a set (i.e., remove duplicates).
    Set<Integer> doubleOfEven =
      numbers.stream()
             .filter(e -> e % 2 == 0)
             .map(e -> e * 2)
             .collect(Collectors.toSet());
    
    System.out.println(doubleOfEven);
  }
}