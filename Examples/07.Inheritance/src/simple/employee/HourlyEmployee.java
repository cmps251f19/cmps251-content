package simple.employee;

//Total: 5pts

//1pt for extends
public class HourlyEmployee extends Employee {
	private double hourlyRate;
	private double hoursWorked;

	//2pts for constructor and attributes
	public HourlyEmployee( String firstName, String lastName,
			double hoursWorked, double hourlyRate) {
		super( firstName, lastName);
		setHoursWorked(hoursWorked);
		setHourlyRate(hourlyRate);
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	//2pts for the method
	public double getPaymentAmount() {
		return hourlyRate * hoursWorked;
	}
}