package _03.matching;

import java.util.List;

public class Matching {

	public static void main(String[] args) {
		List<Employee> employees = List.of(
				new Employee("Abbess Ibn Firnas", 100000),
				new Employee("Juha Dahak", 10000)
		);
		boolean isSomeoneMegaRich = employees.stream().anyMatch(e -> e.getSalary() >= 100000);
		boolean isEveryoneMegaRich = employees.stream().allMatch(e -> e.getSalary() >= 100000);
		
		System.out.printf("Someone mega rich? %s.%n", isSomeoneMegaRich);
		System.out.printf("Everyone mega rich? %s.%n", isEveryoneMegaRich);
		
		double averageSalary =
				employees.stream()
				.mapToDouble(Employee::getSalary)
				.average() // average returns OptionalDouble,
				.getAsDouble();
		
		System.out.printf("Average salary: %.2f.%n", averageSalary);
	}
}