package custom.exception2;

public class AlreadyExistsException extends Exception {
	private String dataToAdd; //with getters and setters
	private String destination;
	public AlreadyExistsException(String message) {
        super(message);
    }

	public AlreadyExistsException(String message, String dataToAdd, String destination) {
        super(message);
        this.dataToAdd = dataToAdd;
        this.destination = destination;
    }

    public AlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

	public String getDataToAdd() {
		return dataToAdd;
	}

	public String getDestination() {
		return destination;
	}
}