package _7.properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
public class Counter {
	private int value;
	public final int getValue() { return value; }
	public final void setValue(int i) { value = i; }
}
*/

public class Counter {
	private IntegerProperty value = new SimpleIntegerProperty(this, "value");
	public final IntegerProperty valueProperty() {
		return value;
	}
	public final int getValue() { return value.get(); }
	public final void setValue(int i) { value.set(i); }
}