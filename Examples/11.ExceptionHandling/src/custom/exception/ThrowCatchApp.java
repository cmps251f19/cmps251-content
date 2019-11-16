package custom.exception;


public class ThrowCatchApp {
	public static void main(String[] args) {
		int grades[] = { 14, 19, 20, 17, 10, 16 };
		try {
			int searchKey = 30;
			int foundAt = searchArray(grades, searchKey);
			System.out.printf("The value %d was found at index %d", searchKey, foundAt);
		} catch (NotFoundException e) {
			System.out.printf("%s The search key was: %s ", 
					e.getMessage(), e.getSearchKey());
		}
	}

	public static int searchArray(int intArray[], int searchKey)
			throws NotFoundException {
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == searchKey)
				return i;
		}
		throw new NotFoundException("Value not found.", searchKey);
	}
}
