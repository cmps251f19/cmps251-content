package custom.exception;
public class InvalidLoginException extends Exception {
	//An example of throwing it could be: 
	//throw new InvalidLoginException("Email and/or password are invalid");
	public InvalidLoginException(String message) {
        super(message);
    }
    
    public InvalidLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}

