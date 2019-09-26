package enums.book;

public class ExceptionExemple {
	public static void main(String[] args) {
		int[] nums = {3, 5, 9};
		try {
			System.out.println(nums[3]);
		} catch(ArrayIndexOutOfBoundsException  ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println("nums array size: " + nums.length);
	}
}