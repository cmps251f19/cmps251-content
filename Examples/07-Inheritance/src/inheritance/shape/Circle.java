package inheritance.shape;

public class Circle extends Shape{ 
	// private instance variable, not accessible from outside this class
	private double radius;


	// 1st constructor, which sets both radius and color to default
	public Circle() {
		//default values
		super("red");
		radius = 2.0;
	}

	// 2nd constructor with given radius and color
	public Circle(double radius, String color) {
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
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public String toString() {
		return String.format("Circle: Color = %s & its area = %.2f", 
				 getColor(), getArea());
	}
}