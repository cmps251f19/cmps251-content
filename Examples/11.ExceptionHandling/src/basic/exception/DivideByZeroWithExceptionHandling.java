package basic.exception;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling {
	// demonstrates throwing an exception when a divide-by-zero occurs
	public static int quotient(int numerator, int denominator)
			throws ArithmeticException {
		return numerator / denominator; // possible division by zero
	}

	public static void main(String[] args) {
		 // scanner for input
		boolean continueLoop = true; // determines if more input is needed
		
		Scanner scanner =new Scanner(System.in);
		do {
			try {
			// read two numbers and calculate quotient
				System.out.print("Please enter an integer numerator: ");
				int numerator = scanner.nextInt();
				System.out.print("Please enter an integer denominator: ");
				int denominator = scanner.nextInt();

				int result = quotient(numerator, denominator);
				System.out.printf("\nResult: %d / %d = %d\n", numerator,
						denominator, result);
				continueLoop = false; // input successful; end looping
			} 
			catch (NoSuchElementException noSuchElementException) {
				System.err.printf("\nException: %s\n", noSuchElementException);
				scanner.nextLine(); // discard input so user can try again
				System.out.println("You must enter integers. Please try again.\n");
			} 
			catch (ArithmeticException arithmeticException) {
				System.err.printf("\nException: %s\n", arithmeticException);
				System.out.println("Zero is an invalid denominator. Please try again.\n");
			} 
		} while (continueLoop);
	}
}