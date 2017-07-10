package ds.stack;

import ds.queue.LinkedQueue;
import ds.queue.QueueUnderflowException;

public class StackWithTwoQueue<T> {

	LinkedQueue<T> queue1 = new LinkedQueue<>();
	LinkedQueue<T> queue2 = new LinkedQueue<>();
	
	public void push(T data) {

		if(queue1.isEmpty())
		{
			queue2.enqueue(data);
		}
		else
		{
			queue1.enqueue(data);
		}
	}

	public T pop() throws QueueUnderflowException {

		int size = 0,i =0;
		if(queue1.isEmpty())
		{
			size = queue2.size();
			while(i<size-1)
			{
				queue1.enqueue(queue2.dequeue());
				i++;
			}
			return queue2.dequeue();
		}
		else
		{
			size = queue1.size();
			while(i<size-1)
			{
				queue2.enqueue(queue1.dequeue());
				i++;
			}
			return queue1.dequeue();
		}
	}

}
