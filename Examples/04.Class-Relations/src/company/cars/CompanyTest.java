package company.cars;

public class CompanyTest {
	public static void main(String[] args) {
		//Create a company named JavaCo
		Company company = new Company("JavaCo");
		//Create a car with a plateNumber T123 and make Toyota
		Car car1 = new Car("T123", "Toyota");
		
		//Create a car with a plateNumber N123 and make Nissan
		Car car2 = new Car("N123", "Nissan");
		company.addCar(car1);
		company.addCar(car2);
		
		//Get the car with plate number T123
		//This line will output Toyota
		System.out.println(company.getCar("T123"));
		
	}
}
