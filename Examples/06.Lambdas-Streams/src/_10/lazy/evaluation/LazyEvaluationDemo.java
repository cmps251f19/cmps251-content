package _10.lazy.evaluation;

import java.util.List;
import java.util.function.Predicate;

public class LazyEvaluationDemo {
	static int callsCount = 0;
	static Predicate<Integer> checkGreaterThan3 = e -> { 
		callsCount++;
		System.out.printf("Checking if %d > 3 \n", e);
		return (e > 3);
	};
	
	static Predicate<Integer> checkEven = e -> { 
		System.out.printf("Checking if % d is even \n", e);
		return (e % 2 == 0);
	};
			
	public static void main(String[] args) {
	    List<Integer> numbers = List.of(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
	    
	    Integer firstEven = numbers.stream()
								   .filter(checkGreaterThan3)
								   .filter(checkEven)
								   .findFirst().orElse(null);
	    
	    System.out.printf("The double of the first even number > 3: %d \n", firstEven);
	    System.out.printf("Predicates call count: %d \n", callsCount);
	}

}
