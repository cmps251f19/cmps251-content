package inheritance.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		
		Circle circle1 = new Circle(3, "White");
		System.out.println(circle1);

		Cylinder cylinder1 = new Cylinder();
		System.out.println(cylinder1);

		Cylinder cylinder2 = new Cylinder(5.0, 2.0);
		System.out.println(cylinder2);
		
		shapes.add(circle1);
		shapes.add(cylinder1);
		shapes.add(cylinder2);
		
		System.out.println("\nProcessing shapes polymorphically");
		for(Shape shape : shapes)
			System.out.println(shape);
	}

}
