package _11.generator;

import java.util.stream.Stream;

public class ObjectGenerator {

	public static void main(String[] args) {
		// Lazy evaluation will not produce the results until we use forEach
		Stream<Integer> integers = Stream.iterate(0, n -> n + 1);
		integers.limit(5).forEach(System.out::println);
		
		Stream<BankAccount> accounts = Stream.generate(BankAccount::new).limit(5);
		accounts.forEach(System.out::println);

		accounts = Stream.iterate(0, n -> n + 1000).map(BankAccount::new).limit(5);

		accounts.forEach(System.out::println);
	}
}