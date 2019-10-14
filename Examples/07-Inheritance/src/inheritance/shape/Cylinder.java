package inheritance.shape;

//Define Cylinder class, which is a subclass of Circle
public class Cylinder extends Circle {
	private double height; // Private member variable

	public Cylinder() { // constructor 1
		//No need to do so. The default  superclass' constructor Circle() will be called
		super(); 
		height = 1.0;
	}

	public Cylinder(double radius, double height) { // Constructor 2
		super(radius, "white"); // invoke superclass' constructor Circle(radius)
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolume() {
		return getArea() * height; // Use Circle's getArea()
	}
	
	public String toString() {
		String format = "Cylinder: Radius = %.2f   Height = %.2f  Color = %-6s   Base area = %.2f\t Volume is: %.2f";
		return String.format(format, 
				getRadius(), getHeight(), getColor(),
				getArea(), getVolume());
	}
}