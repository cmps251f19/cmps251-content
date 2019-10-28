package _8.properties;

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
        
        num1.addListener((valueInt, oldVal, newVal) -> 
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
        
		final StringProperty textProp = new SimpleStringProperty("Salam");
		System.out.println("textProp: " + textProp);
		System.out.println("getValue(): " + textProp.getValue());

		final IntegerProperty intProp1 = new SimpleIntegerProperty(10);
		final IntegerProperty intProp2 = new SimpleIntegerProperty(2);
		System.out.println("subtract(): " + intProp1.add(40).subtract(intProp2));
		System.out.println("multiply(): " + intProp1.multiply(intProp2).getValue());
	}
}

/*
public class Conference {
 private StringProperty name = new SimpleStringProperty();
 Conference(String name) { setName(name); }
 public StringProperty nameProperty() { return this.name; } 
 public String getName() { return this.name.get( ); } 
 public void setName(String name) { this.name.set(name); }
}
final Conference conf = new Conference();
nameTf.textProperty().bindBidirectional(conf.nameProperty());
*/