package exceptionExample;

public class DateTest {
	public static void main(String[] args) {
		try {
			Date date = new Date(40, 12);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
