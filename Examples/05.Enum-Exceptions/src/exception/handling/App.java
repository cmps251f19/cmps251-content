package exception.handling;

public class App {

	public static void main(String[] args) {
		try {
			int[] nums = {3, 5, 9};
			System.out.println(nums[3]);
			System.out.println("nums array size: " + nums.length);
		}
		catch (IndexOutOfBoundsException ex){
			System.err.println(ex.getMessage());
		}
		
		try {
			int[] nums = null;
			System.out.println("nums array size: " + nums.length);
		}
		catch (NullPointerException ex){
			System.err.println(ex.toString());
		}
	}
}