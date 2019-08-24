import java.util.Scanner;

public class _4IfElse {
	public static void main(String arg[]) {
		Scanner input = new Scanner(System.in);
		int x;
		System.out.print("Enter an integer: ");
		x = input.nextInt();

		if (x % 2 == 0)
			System.out.printf("%d %s", x, "is even number");
		else
			System.out.printf("%d %s", x, "is odd number");
	}
}