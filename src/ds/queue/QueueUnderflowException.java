package ds.queue;

public class QueueUnderflowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8846235667681189971L;

	public QueueUnderflowException() {
		super("Queue is empty");
	}

	public QueueUnderflowException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public QueueUnderflowException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public QueueUnderflowException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public QueueUnderflowException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
