package enums.book;

public class ExampleEnum {



	public enum Gender {
		FEMALE('F'),
		MALE('M');
		
		private char abbreviation;
		
		private Gender(char abbreviation) {
			this.abbreviation = abbreviation;
		}
		
		public char getAbbreviation() {
			return abbreviation;
		}
	} 
	
	public static void main(String[] args) {
		
		
		for(var state : TraffiLightState.values()) {
			System.out.println(state + " stays on for " + state.getDuration());
		}
		
		Gender gender= Gender.FEMALE;
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
