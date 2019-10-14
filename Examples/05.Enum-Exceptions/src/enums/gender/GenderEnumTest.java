package enums.gender;

public class GenderEnumTest {
	public static void main(String[] args) {
		Gender gender = Gender.FEMALE;
		System.out.println("Gender Value:" 
				+ gender + " - Gender ToString:" + gender.toString());
		
		for(var enumValue : Gender.values()) {
			System.out.println(enumValue + " abbreviated as " + enumValue.getAbbreviation());
		}

		switch(gender) {
		case FEMALE:
			System.out.println("She is outstanding");
			break;
		case MALE:
			System.out.println("He is outstanding");
			break;
		}
	}
}
