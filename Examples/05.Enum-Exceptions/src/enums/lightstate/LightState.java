package enums.lightstate;

public enum LightState {
	// Each object is initialized to a color.
	OFF("black"),
	ON("white"), 
	DIMMED("gray"), 
	FLICKERING("red");

	private final String color;

	// Private constructor to set the color.
	private LightState(String color) {
		this.color = color;
	}

	// Public accessor to get color.
	public String getColor() {
		return color;
	}
}

