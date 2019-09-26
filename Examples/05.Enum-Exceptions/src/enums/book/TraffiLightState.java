package enums.book;

public enum TraffiLightState {
	GREEN(40),
	YELLOW(5),
	RED(50);
	
	private int duration;
	
	private TraffiLightState(int duration) {
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
}
