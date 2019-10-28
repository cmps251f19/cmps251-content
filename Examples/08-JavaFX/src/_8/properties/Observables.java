package _8.properties;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class Observables {
	public static void main(String[] args) {
		final String[] content = { "Orig1", "Orig2" };
		final ObservableList<String> observableList =
				FXCollections.observableArrayList(content);
		
		observableList.addListener((ListChangeListener<String>) change ->
				System.out.println("Changed to: " + change.getList()));
		
		observableList.addAll("A", "B", "C");
		observableList.removeAll("Orig1", "Orig2");
		observableList.add("1");
		observableList.add("2");
	}
}
