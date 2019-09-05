package equalsExample;

public class Fraction {
	int numerator;
	int denominator;

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public boolean equals(Fraction f) {
		return this.numerator == f.numerator
				&& this.denominator == f.denominator;
	}

}
