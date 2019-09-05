package rectangle;

public class RectangleTest {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(12.5, 5.5);

		System.out.printf("The sides of r1 are: %.2f and %.2f\n",
				r1.getLength(), r1.getWidth());

		System.out.printf("The sides of r2 are: %.2f and %.2f\n",
				r2.getLength(), r2.getWidth());

		r2.setSides(6, 6);
		System.out.printf("The surface of r2 is: %.2f\n", r2.getSurface());

		System.out.printf("The default size of the sides: %.2f\n",
				Rectangle.DEFAULT_SIZE);
	}
}
