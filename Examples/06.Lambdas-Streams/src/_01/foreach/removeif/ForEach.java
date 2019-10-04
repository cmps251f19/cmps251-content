package _01.foreach.removeif;

import java.util.List;

public class ForEach {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    
    // List iterator using a loop
    for(int i = 0; i < numbers.size(); i++) {
    	System.out.println(numbers.get(i));
    }
    
    // List iterator using feach each loop
    for(var e : numbers) {
       int doubled = e * 2;
       System.out.println(e);
    }
    
    // Using forEach and a lambda expression
    numbers.forEach( e -> System.out.println(e));
    
    numbers.forEach( System.out::println );
 
    //Can be improved to:
    numbers.forEach( System.out::println );
  }
}