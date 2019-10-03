package exception.throwexample;

public class DateTest {
	public static void main(String[] args) {
		try {
			Date date = new Date(13, 12, 2018);
			System.out.printf("%d/%d/%d", date.getDay(), date.getMonth(), date.getYear());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
