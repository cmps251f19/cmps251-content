package enums.example;

public enum LightState {
	// Each object is initialized to a color.
	OFF("black"),
	ON("white"), 
	DIMMED("gray"), 
	FLICKERING("red");

	private final String colorField;

	// Private constructor to set the color.
	private LightState(String color) {
		colorField = color;
	}

	// Public accessor to get color.
	public String getColor() {
		return colorField;
	}
}

