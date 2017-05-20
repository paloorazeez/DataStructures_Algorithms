package ds.linkedlist;

public class Node<E>{
	public Node<E> next;
	public E data;
	public Node(E data) {
		this.data = data;
		this.next = null;
	}
	
	public Node() {
	}
}