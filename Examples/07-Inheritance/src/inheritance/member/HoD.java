package inheritance.member;

import java.util.Date;

public class HoD extends Instructor {
	Date appointmentDate;

	public HoD() {
		super();
	}

	public HoD(int id, String firstName, String lastName, String email,
			String office, int yearsExperience, Date appointmentDate) {
		super(id, firstName, lastName, email, office, yearsExperience);
		this.appointmentDate = appointmentDate;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
}
