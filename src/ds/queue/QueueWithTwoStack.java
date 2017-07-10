package ds.queue;

import ds.stack.LinkedStack;
import ds.stack.StackUnderflowException;

public class QueueWithTwoStack<T> {

	private LinkedStack<T> stack1 = new LinkedStack<>();
	private LinkedStack<T> stack2 = new LinkedStack<>();
	
	public void enqueue(T data) {

		stack1.push(data);
	}

	public T dequeue() throws StackUnderflowException {
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

}
