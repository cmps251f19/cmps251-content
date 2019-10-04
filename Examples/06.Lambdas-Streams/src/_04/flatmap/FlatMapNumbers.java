package _04.flatmap;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapNumbers {

	public static void main(String[] args) {

        // Creating a list of Prime Numbers 
        List<Integer> PrimeNumbers = List.of(5, 7, 11,13); 
          
        // Creating a list of Odd Numbers 
        List<Integer> OddNumbers = List.of(1, 3, 5); 
          
        // Creating a list of Even Numbers 
        List<Integer> EvenNumbers = List.of(2, 4, 6, 8); 
  
        List<List<Integer>> listOfListofInts = 
                List.of(PrimeNumbers, OddNumbers, EvenNumbers); 
  
        System.out.println("The list before flattening is : " + 
                                                  listOfListofInts); 
          
        // Using flatMap for transformating and flattening. 
        List<Integer> listofInts  = listOfListofInts.stream() 
                                    .flatMap(list -> list.stream()) 
                                    .collect(Collectors.toList()); 
  
        System.out.println("The list after flattening is : " + listofInts); 
	}

}
