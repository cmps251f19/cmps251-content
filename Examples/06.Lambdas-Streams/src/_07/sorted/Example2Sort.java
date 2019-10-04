package _07.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Example2Sort {

 public static void main(String[] args) {
	List<String> alphabetWords = List.of("alfa", "bravo", "charlie", "delta", 
			"echo", "foxtrot", "golf", "hotel",
			"india", "juliet", "kilo", "lima", "mike", 
			"november", "oscar", "papa", "quebec", "romeo", "sierra",
			"tango", "uniform", "victor", "whiskey", "x-ray", 
			"yankee", "zulu");
	
	Stream<String> sortedWords =
			alphabetWords.stream()
						  .sorted(
						     Comparator.comparing(String::length).reversed()
						     		   .thenComparing(Comparator.reverseOrder())
						  );
	
	sortedWords.forEach(System.out::println);
  }
}
