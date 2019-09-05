package staticExample1;

public class UseUtils {

	private static String universityName = "Qatar University";
	
	public static void main(String[] args) {
		
		System.out.println(universityName);
		System.out.println(Math.max(100, 200));
		
		//System.out.println
		
		System.out.println(Math.PI);
		System.out.println(Math.sqrt(9));
		
		var myInt = Integer.valueOf(10);
		System.out.println(myInt.doubleValue());
		
		System.out.println(Integer.BYTES);
		System.out.println(Integer.min(6, 10));		
	}
}