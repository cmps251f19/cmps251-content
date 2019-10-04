package _02.map.filter;

import java.util.List;

public class Example3Alphabet {
	public static void main(String[] args) {
		List<String> alphabetWords = List.of("alfa", "bravo", "charlie", "delta", 
				"echo", "foxtrot", "golf", "hotel",
				"india", "juliet", "kilo", "lima", "mike", 
				"november", "oscar", "papa", "quebec", "romeo", "sierra",
				"tango", "uniform", "victor", "whiskey", "x-ray", 
				"yankee", "zulu");

		alphabetWords.stream()
				.map(String::toUpperCase)
				.filter(word -> word.length() == 6)
				.forEach(System.out::println);
	}
}
