import java.util.*;

public class _6ForLoopRandomNums {
	public static void main(String[] args) {
		System.out.print("How many random nums? ");
		Scanner inputScanner = new Scanner(System.in);
		int n = inputScanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Random num %d is %2.6f\n", i, Math.random());
		}

		inputScanner.close();
	}
}
