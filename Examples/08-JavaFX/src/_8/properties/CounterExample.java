package _8.properties;

import javafx.beans.property.IntegerProperty;

public class CounterExample {

	public static void main(String[] args) {
		/*
			From a caller’s perspective, no difference
				– Data storage is encapsulated behind getters / setters
				– Looks like a normal class
			• Attribute storage is wrapped inside the Property object 
		*/
		// Can use as a normal object
		Counter counter = new Counter();
		counter.setValue(10);
		System.out.println("Counter: " + counter.getValue());
		
		// Or use property object
		IntegerProperty property = counter.valueProperty();
		property.set(20);
		System.out.println("Counter: " + property.get());

	}

}
