package _03.collect;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; 

public class ToList {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

    //Double the even values and put that into a list.
    
    //Not the best way to do this.
    List<Integer> doubleOfEven = new ArrayList<>();

    numbers.stream()
           .filter(e -> e % 2 == 0)
           .map(e -> e * 2)
           .forEach(e -> doubleOfEven.add(e));
    
    System.out.println(doubleOfEven);
    
    List<Integer> doubleOfEven2 =
      numbers.stream()
             .filter(e -> e % 2 == 0)
             .map(e -> e * 2)
             .distinct()
             .collect(Collectors.toList());
    
    System.out.println(doubleOfEven2);
  }
}