package ds.stack;

import ds.linkedlist.Node;

public class LinkedStack<E> {

	int length;
	Node<E> top;
	public boolean isEmpty() {
		return (length==0);
	}
	
	public void push(E data) {
	
		Node<E> temp = new Node<E>(data);
		temp.next = top;
		top = temp;
		length++;
	}

	public String print() {

		Node<E> temp = top;
		StringBuilder sb = new StringBuilder();
		while(temp != null)
		{
			sb.append(temp.data).append(" ");
			temp = temp.next;
		}
		return sb.toString();
	}

	public E pop() throws StackUnderflowException {
		if(isEmpty())
		{
			throw new StackUnderflowException("Stack does not contain any value");
		}
		Node<E> temp = top;
		top = top.next;
		length--;
		return temp.data;
	}

	public int size() {
		return length;
	}

	public E peak() throws StackUnderflowException {
		if(isEmpty())
		{
			throw new StackUnderflowException("Stack is empty");
		}
		return top.data;
	}

}
