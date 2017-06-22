package ds.queue;

public class QueueOverflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8394086542787512987L;

	public QueueOverflowException() {
		super("Queue is full");
	}

	public QueueOverflowException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public QueueOverflowException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public QueueOverflowException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public QueueOverflowException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
