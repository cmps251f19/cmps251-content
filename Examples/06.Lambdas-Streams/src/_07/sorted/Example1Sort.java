package _07.sorted;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1Sort {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(8, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
    
    numbers.stream()
           .filter(e -> e % 2 == 0)
           .sorted()
           //.sorted(Comparator.reverseOrder())
           .forEach(System.out::println);
    
    List<String> words = Arrays.asList("The quick brown fox jumps over the lazy dog".split(" "));
    
    // Sort words by word length
    String sortedWords = words.stream()
    						  .sorted( Comparator.comparing(w -> w.length()) )
    						  .collect(Collectors.joining(" "));
    
    System.out.println( sortedWords );
    
    // Sort words by word length then alphabetically
    sortedWords = words.stream()
    				   .sorted( Comparator.comparing(String::length)
    						   			  .thenComparing(Comparator.naturalOrder())
    						  )
    				   .collect(Collectors.joining(" "));
    
    System.out.println( sortedWords );
    
    String longestWord = words.stream().max((v, w) -> v.length() - w.length()).orElse("");
    System.out.println( longestWord );
  }
}