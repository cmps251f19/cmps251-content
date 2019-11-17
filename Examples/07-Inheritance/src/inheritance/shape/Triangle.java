package inheritance.shape;

public class Triangle extends Shape {
	private double base;
	private double height;
	
	public Triangle(String color, double base, double height) {
		super(color);
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public double getHeight() {
		return height;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return base * height / 2;
	}
	
	@Override
	public String toString() {
		return String.format("%s - Base: %.2f - Height: %.2f", 
				super.toString(),
				getBase(), getHeight());
	}
}