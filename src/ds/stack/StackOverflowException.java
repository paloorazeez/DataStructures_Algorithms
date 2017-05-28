package ds.stack;

public class StackOverflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1310605789681545608L;

	public StackOverflowException() {
		super("Stack is full");
	}
	public StackOverflowException(String msg) {
		super(msg);
	}

}
