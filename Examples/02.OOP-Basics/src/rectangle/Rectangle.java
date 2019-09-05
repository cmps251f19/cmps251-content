package rectangle;

public class Rectangle {
	public static final double DEFAULT_SIZE = 5.0;
	private double length;
	private double width;

	public Rectangle() {
		setSides(DEFAULT_SIZE, DEFAULT_SIZE);
	}

	public Rectangle(double length, double width) {
		setSides(length, width);
	}

	public void setSides(double length, double width) {
		if (length > 0)
			this.length = length;
		else
			throw new IllegalArgumentException("The length must be positive");

		if (width > 0)
			this.width = width;
		else
			throw new IllegalArgumentException("The width must be positive");

	}

	public double getSurface() {
		return length * width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}
}
