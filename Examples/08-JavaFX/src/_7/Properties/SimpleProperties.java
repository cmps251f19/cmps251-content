package _7.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleProperties {
	public static void main(String[] args) {
		IntegerProperty num1 = new SimpleIntegerProperty(1);
		IntegerProperty num2 = new SimpleIntegerProperty(2);
        num1.bind(num2);

        System.out.println("num1 is " + num1.getValue()
                    + " and num2 is " + num2.getValue());

        num2.setValue(15);

        System.out.println("num1 is " + num1.getValue()
                    + " and num2 is " + num2.getValue());

        
		final StringProperty textProp = new SimpleStringProperty("Salam");
		System.out.println("textProp: " + textProp);
		System.out.println("getValue(): " + textProp.getValue());

		final IntegerProperty intProp1 = new SimpleIntegerProperty(10);
		final IntegerProperty intProp2 = new SimpleIntegerProperty(2);
		System.out.println("subtract(): " + intProp1.add(40).subtract(intProp2));
		System.out.println("multiply(): " + intProp1.multiply(intProp2).getValue());
	}
}
