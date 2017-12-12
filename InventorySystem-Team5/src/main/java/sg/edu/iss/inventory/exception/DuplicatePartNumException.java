package sg.edu.iss.inventory.exception;

public class DuplicatePartNumException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicatePartNumException() {
		super();
	}

	public DuplicatePartNumException(String string) {
		super(string);
	}
}
