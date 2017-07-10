package ds.queue;

import ds.linkedlist.Node;
import ds.stack.LinkedStack;
import ds.stack.StackUnderflowException;

public class LinkedQueue<E> {

	private Node<E> front, rear;
	private int length;
	public void enqueue(E data) {

		Node<E> newNode = new Node<>(data);
		if(isEmpty())
		{
			front = newNode;
		}
		else{
			rear.next = newNode;
		}
		rear = newNode;
		length++;
	}
	public boolean isEmpty() {
		return length==0;
	}
	public String print() {
		StringBuilder elements = new StringBuilder();
		Node<E> temp = front;
		while(temp != null)
		{
			elements.append(temp.data).append(" ");
			temp = temp.next;
		}
		return elements.toString();
	}
	public E dequeue() throws QueueUnderflowException {
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		Node<E> frontNode = front;
		front = front.next;
		length--;
		return frontNode.data;
	}
	public LinkedQueue reverse() throws QueueUnderflowException, StackUnderflowException {
		LinkedStack stack = new LinkedStack();
		while(!isEmpty())
		{
			stack.push(this.dequeue());
		}
		
		while(!stack.isEmpty())
		{
			this.enqueue((E) stack.pop());
		}
		return this;
	}
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}
	public boolean pairwiseOrder(LinkedStack<Integer> stack) throws StackUnderflowException, QueueUnderflowException {
		boolean pairwiseOrdered = true;
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		while(!stack.isEmpty())
		{
			queue.enqueue(stack.pop());
		}
		while(!queue.isEmpty())
		{
			stack.push(queue.dequeue());
		}
		
		while(!stack.isEmpty())
		{
			int n = stack.pop();
			queue.enqueue(n);
			if(!stack.isEmpty())
			{
				int m = stack.pop();
				queue.enqueue(m);
				if((Math.abs((n-m)) != 1))
						{
					pairwiseOrdered = false;
						}
			}
		}
		
		while(!queue.isEmpty())
		{
			stack.push(queue.dequeue());
		}
		return pairwiseOrdered;
	}
}
