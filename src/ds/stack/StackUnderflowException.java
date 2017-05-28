package ds.stack;

public class StackUnderflowException extends Exception {

	public StackUnderflowException(String msg) {
		super(msg);
	}

	public StackUnderflowException() {
			super("Stack is empty");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6269678778054010732L;

}
