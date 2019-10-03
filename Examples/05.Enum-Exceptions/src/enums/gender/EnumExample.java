package enums.gender;

public class EnumExample {

	enum Gender {
		FEMALE,
		MALE
	}
	
	enum Days{
	   SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}
	
	enum Directions {
		NORTH, SOUTH, EAST, WEST
	}

	public static void main(String[] args) {
		
		Gender gender = Gender.FEMALE;
		
		switch (gender) {
			case FEMALE:
				System.out.println("She is outstanding");
				break;
		
			case MALE:
				System.out.println("He is outstanding");
				break;
			}
		}
}
