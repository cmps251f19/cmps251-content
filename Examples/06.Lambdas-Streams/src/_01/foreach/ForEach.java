package _01.foreach;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ForEach {
  public static void main(String[] args) {
	//Stream<Integer> integers = Stream.iterate(0, n -> n + 1);
	//integers.forEach(System.out::println);

    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    numbers.forEach( e -> System.out.println(e) );
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