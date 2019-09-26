package enums.lightstate;

public class LightStateEnumTest {
	public static void main(String[] args) {
		LightState off = LightState.OFF;
		LightState on = LightState.ON;
		LightState dimmed = LightState.DIMMED;
		LightState flickering = LightState.FLICKERING;
		
		System.out.println("Value:" + off 
				+ " State:" + off.toString() 
				+ " :: Color:" + off.getColor());
		
		System.out.println("State:" + on + " :: Color:" + on.getColor());
		System.out.println("State:" + dimmed + " :: Color:"	+ dimmed.getColor());
		System.out.println("State:" + flickering.toString() + " :: Color:" + flickering.getColor());
	}
}
