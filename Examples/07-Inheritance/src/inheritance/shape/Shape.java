package inheritance.shape;

public abstract class Shape {

	private String color;
	public Shape() {
	}
	
	public Shape(String color) {
		this.setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double getArea();
	
	@Override
	public String toString() {
		return String.format("%s Area: %.2f", 
				getClass().getSimpleName(),
				getArea());
	}
	

}
