package inheritance.shape;

//Define Cylinder class, which is a subclass of Circle
public class Cylinder extends Circle {
	private double height;

	public Cylinder(String color, double radius, double height) {
		super(color, radius);
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
	
	@Override
	public double getArea() {
		//Area = 2πrh+2πr*r
		return 2 * Math.PI * getRadius() * getHeight() +
			   2 * Math.PI * getRadius() * getRadius();
	}
	
	@Override
	public String toString() {
		return String.format("%s - Height: %.2f - Volume: %.2f", 
				super.toString(),
				getHeight(), getVolume());
	}
}