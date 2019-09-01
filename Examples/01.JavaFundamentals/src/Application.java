
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lamp lamp = new Lamp();
		lamp.setBrand("Philips");
		lamp.turnOn();
		System.out.println(lamp.getBrand() + " is on : " + lamp.isOn());
	}

}
