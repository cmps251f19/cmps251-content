
public class Lamp {
	
	private String shape;
	private String color;
	private String brand;
	private int noOfWatts;
	private boolean isOn = false;
	
	public void turnOn() {
		isOn = true;
	}

	public void turnOff() {
		isOn = false;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNoOfWatts() {
		return noOfWatts;
	}

	public void setNoOfWatts(int noOfWatts) {
		this.noOfWatts = noOfWatts;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
}