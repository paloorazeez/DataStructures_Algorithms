package ds.queue;

public class StaticQueue {

	private int capacity;
	private int size;
	private int front;
	private int rear;
	private int queueArr[];
	public StaticQueue(int capacity) {
		this.capacity = capacity;
		this.front = this.rear = this.size =0;
		this.queueArr = new int[this.capacity];
	}

	public void enqueue(int data) throws QueueOverflowException {
		
		if(this.size == this.capacity)
		{
			throw new QueueOverflowException();
		}
		
		size++;
		queueArr[rear] = data;
		rear = (rear+1)%capacity;
		
		
	}

	public String print() {
		StringBuilder arrayElements = new StringBuilder();
		if(front>rear)
		{
			
			for(int i= front; i<capacity;i++)
			{
				if (queueArr[i]>0) {
					arrayElements.append(queueArr[i]).append(" ");
				}
			}
			for (int i = 0; i < rear; i++) {
				if (queueArr[i]>0) {
					arrayElements.append(queueArr[i]).append(" ");
				}
			}
		}
		else
		{
			
			for(int i= 0; i<size;i++)
			{
				if (queueArr[i]>0) {
					arrayElements.append(queueArr[i]).append(" ");
				}
			}
		}
		return arrayElements.toString();
	}

	public int dequeue() throws QueueUnderflowException {
		if(size == 0)
		{
			throw new QueueUnderflowException();
		}
		size--;
		int data = queueArr[front%capacity];
		queueArr[front] = Integer.MIN_VALUE;
		front = (front+1)%capacity;
		return data;
	}

}
