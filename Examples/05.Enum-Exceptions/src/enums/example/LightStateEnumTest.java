package enums.example;

public class LightStateEnumTest {
	public enum Gender {
		FEMALE,
		MALE
	}
	
	public static void main(String[] args) {
		Gender gender = Gender.FEMALE;
		System.out.println("Gender Value:" + gender + " - Gender ToString:" 
				+ gender.toString());
		
		switch(gender) {
		case FEMALE:
			System.out.println("Female");
			break;
		case MALE:
			System.out.println("Male");
			break;
		}
		
		LightState off = LightState.OFF;
		LightState on = LightState.ON;
		LightState dimmed = LightState.DIMMED;
		LightState flickering = LightState.FLICKERING;
		
		System.out.println("Value:" + off + " State:" 
				+ off.toString() + " :: Color:"
				+ off.getColor());
		
		System.out.println("State:" + on.toString() + " :: Color:"
				+ on.getColor());
		
		System.out.println("State:" + dimmed.toString() + " :: Color:"
				+ dimmed.getColor());
		
		System.out.println("State:" + flickering.toString() + " :: Color:"
				+ flickering.getColor());
	}
}
