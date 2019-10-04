package _01.foreach.removeif;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		// Remove elements < 4
		numbers.removeIf(n -> n < 4);
		numbers.forEach(System.out::println);
	}
}
