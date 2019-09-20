package company.cars;

public class Car {
	private String plateNumber;
	private String make;
	
	public Car(String plateNumber, String make) {
		this.plateNumber = plateNumber;
		this.make = make;
	}

	public String toString() {
		return make;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
}
