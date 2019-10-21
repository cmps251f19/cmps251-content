package inheritance.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		
		Circle circle1 = new Circle("White", 3);
		Cylinder cylinder1 = new Cylinder("Red", 5, 4);
		Cylinder cylinder2 = new Cylinder("Blue", 3, 9);
		Rectangle rectangle = new Rectangle("Yellow", 7.5, 5.8);
		Triangle triangle = new Triangle("Brown", 10, 20);
		
		shapes.add(circle1);
		shapes.add(cylinder1);
		shapes.add(cylinder2);
		shapes.add(rectangle);
		shapes.add(triangle);
		
		System.out.println("\nProcessing shapes polymorphically");
		for(Shape shape : shapes) {
			System.out.println( shape.toString() );
		}
	}
}