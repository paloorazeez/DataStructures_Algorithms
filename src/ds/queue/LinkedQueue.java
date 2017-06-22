package ds.queue;

import ds.linkedlist.Node;

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
	private boolean isEmpty() {
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
}
