/*
 Write an enum type TrafficLight, whose constants (RED, GREEN, YELLOW) take one parameter: the duration of the light. 
 Write a program to test the TrafficLight enum so that it displays the enum constants and their durations.
*/

package enums.trafficlight;

// Testing enum type TrafficLight.
public class TrafficLightEnumTest {
	
	public static void main(String[] args) {
		TrafficLight lightState = TrafficLight.GREEN;

		System.out.println("lightState value: " + lightState + " - lightState.toString(): " + lightState.toString());

		for (var state : TrafficLight.values()) {
			System.out.println(state + " stays on for " + state.getDuration() + "s");
		}
	}
}