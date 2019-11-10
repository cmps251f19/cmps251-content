package example;

import javafx.beans.property.SimpleIntegerProperty;

public class PropDemo {

	public static void main(String[] args) {
		SimpleIntegerProperty intProp = new SimpleIntegerProperty(60);

		intProp.addListener((observable, oldValue, newValue) -> {
			System.out.println(observable);
			System.out.printf("Old Value: %d, New Value: %d%n", oldValue, newValue);
		});
		
		intProp.set(100);
		intProp.set(200);
		
		System.out.println(intProp.get());

	}

}
