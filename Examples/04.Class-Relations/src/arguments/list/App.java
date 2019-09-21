package arguments.list;

public class App {

	// Variable-Length Argument Lists - Example
	public static double average(double... numbers) {
		double total = 0.0;
		for(var num : numbers) {
			total += num;
		}
		return total / numbers.length;
	}

	public static void main(String[] args) {
		double avg = average(4, 6, 2);
		System.out.println(avg);
	}
	
}