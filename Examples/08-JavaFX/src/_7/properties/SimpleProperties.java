package _7.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleProperties {
	public static void main(String[] args) {
		IntegerProperty num1 = new SimpleIntegerProperty(1);
		IntegerProperty num2 = new SimpleIntegerProperty(2);

		//Unidirectional binding
        //num1.bind(num2); //Changes in num2 are reflected in num1
		//Bidirectional binding
		//Changes in num2 are reflected in num1
		//Changes in num1 are reflected in num2
        num1.bindBidirectional(num2);
        
        num1.addListener((observable, oldVal, newVal) -> 
        	System.out.printf(String.format("** num1 changed from %d to %d %n", oldVal, newVal))
        );

        System.out.println("num1 is " + num1.getValue()
                    + " and num2 is " + num2.getValue());

        num2.setValue(15);

        System.out.println("num1 is " + num1.getValue()
                    + " and num2 is " + num2.getValue());

        num1.setValue(20);
        
        System.out.println("num1 is " + num1.getValue()
					+ " and num2 is " + num2.getValue());
        
		final StringProperty stringProp = new SimpleStringProperty("Salam");
		System.out.println("\nstringProp: " + stringProp);
		System.out.println("get(): " + stringProp.get());

		final IntegerProperty intProp1 = new SimpleIntegerProperty(10);
		final IntegerProperty intProp2 = new SimpleIntegerProperty(2);
		final IntegerProperty sum = new SimpleIntegerProperty(0);
		sum.bind(intProp1.add(intProp2));
		
		System.out.printf("%n%d + %d = %d %n", intProp1.get(), intProp2.get(), sum.get());
		intProp1.set(intProp1.get() + 10);
		System.out.printf("Auto-updated sum %d + %d = %d %n", intProp1.get(), intProp2.get(), sum.get());
		
	}
}