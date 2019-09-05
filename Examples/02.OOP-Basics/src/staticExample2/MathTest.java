package staticExample2;

public class MathTest {

	public static void main(String[] args) {
		System.out.println("Abs(-20) using Java Math Library: " + java.lang.Math.abs(-20));
		System.out.println("10 + 20 = " + Math.add(10, 20));
		
		System.out.println("my Math.PI = " + Math.PI);
		
        int[] numbers = {2, 3, 4, 5};
        System.out.println("Sum = " + Math.sumNumbers(numbers)); 
	}
}
