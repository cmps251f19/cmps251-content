package _3.basics.gettime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Model {
	public static String getCurrentDateTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
    	return DateTimeFormatter.ofPattern("dd/M/yyyy HH:mm:ss a").format(currentDateTime);
	}
}
