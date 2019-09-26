package enums.gender;

/*public class Gender {
	public static final Gender FEMALE = new Gender();
	public static final Gender MALE = new Gender();
}*/

public enum Gender {
	FEMALE('F'),
	MALE('M');
	
	private final char abbreviation;
	
	private Gender(char abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public char getAbbreviation() {
		return abbreviation;
	}
}
