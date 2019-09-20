package company.cars;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private List<Car> cars = new ArrayList<>();
	public Company(String name) {
		this.name = name;
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public Car getCar(String plateNumber) {
		for(Car car : cars) {
			if (car.getPlateNumber().equals(plateNumber))
				return car;
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}