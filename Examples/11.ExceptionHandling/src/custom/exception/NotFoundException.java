package custom.exception;

public class NotFoundException extends Exception {
	private int searchKey;
	
	public NotFoundException(String message) {
        super(message);
    }
	
	public NotFoundException(String message, int searchKey) {
        super(message);
        this.searchKey = searchKey;
    }
    
    public int getSearchKey() {
    	return searchKey;
    }
    
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}