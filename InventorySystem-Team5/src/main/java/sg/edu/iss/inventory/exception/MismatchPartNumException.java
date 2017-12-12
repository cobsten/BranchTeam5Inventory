package sg.edu.iss.inventory.exception;

public class MismatchPartNumException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MismatchPartNumException() {
		super();
	}

	public MismatchPartNumException(String string) {
		super(string);
	}
}
