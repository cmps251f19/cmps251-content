package inheritance.shape;

public class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rectangle(String color, double length, double width) {
		super(color);
		setLength(length);
		setWidth(width);
	}
	
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double getArea() {
		return length * width;
	}
}