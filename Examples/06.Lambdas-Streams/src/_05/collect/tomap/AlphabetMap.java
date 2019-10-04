package _05.collect.tomap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlphabetMap {
	public static void main(String[] args) {
		List<String> alphabet = List.of("alfa", "bravo", "charlie", "delta", 
				"echo", "foxtrot", "golf", "hotel",
				"india", "juliet", "kilo", "lima", "mike", 
				"november", "oscar", "papa", "quebec", "romeo", "sierra",
				"tango", "uniform", "victor", "whiskey", "x-ray", 
				"yankee", "zulu");

        Map<String, String> map = alphabet.stream()
                		.collect(Collectors.toMap(
                				s -> s.substring(0, 1),
                				s -> s));
        
        System.out.println(map);
        
        Map<Integer, List<String>> result =
                alphabet.stream()
                		.collect( Collectors.groupingBy(String::length) );
        
        System.out.println(result);
	}
}
