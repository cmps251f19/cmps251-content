package _09.method.references;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import _11.generator.BankAccount;

public class MethodReference
{
   public static void main(String[] args)
   {
	  List<String> words = Arrays.asList("The quick brown fox jumps over the lazy dog".split(" "));
	   
      words.stream()
      		.map(w -> w.toUpperCase())
      		.forEach(w -> System.out.println(w));
      
      words.stream()
		.map(String::toUpperCase)
		//.sorted(String::compareTo);
		.forEach(System.out::println);

      Stream.of(32.0, 54.0, 67.5, 29.0, 35.0, 80.0, 115.0, 44.5, 100.0, 65.0)
         .sorted(Double::compare)
         .forEach(System.out::println);
      
      Stream<String> wordsStream = words.stream();
      String[] array = wordsStream.toArray(String[]::new);
      System.out.println(
         "Using toArray with an array constructor reference: "
         + Arrays.toString(array));
   }
}               
