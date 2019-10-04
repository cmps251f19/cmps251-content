package _06.primitive.streams;

import java.util.List;

public class ReducersBuiltin {

	public static void main(String[] args) {
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = nums.stream().mapToInt(Integer::intValue).sum();
		long count = nums.stream().mapToInt(Integer::intValue).count();
		double average = nums.stream().mapToInt(Integer::intValue).average().orElse(0);
		int max = nums.stream().mapToInt(Integer::intValue).max().orElse(0);
		int min = nums.stream().mapToInt(Integer::intValue).min().orElse(0);
		
		System.out.printf("Sum: %d \n", sum);
		System.out.printf("Count: %d \n", count);
		System.out.printf("Average: %.2f \n", average);
		System.out.printf("Max: %d \n", max);
		System.out.printf("Min: %d \n", min);
	}
}
