package equals.example;

public class FractionTest {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(1, 2);

		if (f1 == f2)
			System.out.println("Both variables refer to the same object");
		else
			System.out.println("Each variable refers to a different object");

		if (f1.equals(f2))
			System.out.println("Both objects have the same value");
		else
			System.out.println("Each object has a different value");
	}
}
