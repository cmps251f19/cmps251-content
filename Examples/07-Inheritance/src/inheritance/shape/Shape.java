package inheritance.shape;

public abstract class Shape {
	private String color;
	
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
		return String.format("%-6s %-9s - Area: %6.2f",
				getColor(),
				getClass().getSimpleName(),
				getArea());
	}
}