package inheritance.shape;

public class Circle extends Shape { 
	// private instance variable, not accessible from outside this class
	private double radius;

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Computes the area of circle
	@Override
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	@Override
	public String toString() {
		return String.format("%s - Radius: %.2f", 
				super.toString(),
				getRadius());
	}
}