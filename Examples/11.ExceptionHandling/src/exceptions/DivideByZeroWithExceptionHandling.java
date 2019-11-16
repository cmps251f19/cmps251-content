package exceptions;
// Fig. 11.2: DivideByZeroWithExceptionHandling.java
// Handling ArithmeticExceptions and InputMismatchExceptions.
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroWithExceptionHandling {
	// demonstrates throwing an exception when a divide-by-zero occurs
	public static int quotient(int numerator, int denominator)
			throws ArithmeticException {
		return numerator / denominator; // possible division by zero
	}

	public static void main(String[] args) {
		/*
		 * You may use the System.err (standard error stream) object to output error messages. 
			- By default, displays data to the command prompt. 
			- Can be redirected to a log file.
		 */
		//Optional - redirect output written to System.err to a file
		PrintStream printStream;
		try {
			printStream = new PrintStream("errors.txt");
			System.setErr(printStream);
			//You can undo it by reassigning the “standard” output stream.
			//System.setOut(System.err); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		Scanner scanner = new Scanner(System.in); // scanner for input
		boolean continueLoop = true; // determines if more input is needed
		
		do {
			try // read two numbers and calculate quotient
			{
				System.out.print("Please enter an integer numerator: ");
				int numerator = scanner.nextInt();
				System.out.print("Please enter an integer denominator: ");
				int denominator = scanner.nextInt();

				int result = quotient(numerator, denominator);
				System.out.printf("\nResult: %d / %d = %d\n", numerator,
						denominator, result);
				continueLoop = false; // input successful; end looping
			} 
			catch (InputMismatchException inputMismatchException) {
				System.err.printf("\nException: %s\n", inputMismatchException);
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