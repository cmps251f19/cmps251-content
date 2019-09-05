package staticExample2;

public class Math {
	public static final double PI = 3.14;
	public static double add(int num1, int num2) {
		return num1 + num2;
	}
	
    public static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int num : numbers)
            sum += num;
        return sum;
    }
}
