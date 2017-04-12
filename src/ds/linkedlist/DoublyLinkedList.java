package ds.linkedlist;

public class DoublyLinkedList<E> {

	
	class Node<E>{
		Node<E> next;
		Node<E> previous;
		E data;
		public Node(E data) {

			this.data = data;
			this.next = null;
			this.previous = null;
		}
		
		public Node(E data, Node<E> previous, Node<E> next) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		@Override
		public String toString() {
			return "["+((previous != null)?previous.data:"null")+" <- " + data + " ->  "+((next != null)?next.data:"null")+"]";
		}
		
		
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int length = 0;
	
	public void printList(boolean printChain)
	{
		Node<E> temp = this.head;
		while(temp != null)
		{
			if (printChain) {
				
				System.out.print(temp.toString()+" ");
			}
			else
			{
				
				System.out.print(temp.data+" ");
			}
			temp = temp.next;
		}
		System.out.println("\n--------------------");
	}
	
	
	public void printHead(boolean printChain)
	{
		if(head != null)
		{
			if(printChain)
			{
				System.out.println("Head:"+head.toString());
			}
			else
			{
				System.out.println("Head:"+head.data);
			}
		}
	}
	
	
	public void printTail(boolean printChain)
	{
		if(tail != null)
		{
			if(printChain)
			{
				System.out.println("Tail:"+tail.toString());
			}
			else
			{
				System.out.println("Tail:"+tail.data);
			}
		}
	}
	
	
	public void printLength()
	{
		System.out.println("Length:"+length);
	}
	public void insertAtBegining(E data)
	{
		Node<E> newNode = new Node<E>(data);
		if(this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			if(head.next == null)
			{
				tail = head;
			}
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		length++;
	}
	
	/*public void insertAtEnd(E data)
	{
		Node<E> newNode = new Node<E>(data);
		if(this.head == null)
		{
			this.head = newNode;
		}
		else
		{
			Node<E> temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			newNode.previous = temp;
			temp.next = newNode;
		}
		length++;
		
	}*/

	public void insertAtEnd(E data)
	{
		Node<E> newNode = new Node<E>(data);
		if(this.head == null)
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		length++;
		
	}
	
	public void insertAt(int position, E data)
	{
		if(position < 0)
		{
			position = 0;
		}
		
		if(position > length )
		{
			position = length;
		}
		
		Node<E> newNode = new Node<E>(data);
	
		if(head == null)
		{
			this.head = newNode;
		}
		
		else if(position == 0)
		{
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		
		else
		{
			Node<E> temp = head;
			for(int i = 1;i<(position-1);i++)
			{
				temp = temp.next;
			}
			
			newNode.next = temp.next;
			newNode.previous = temp;
			temp.next = newNode;
			newNode.next.previous = newNode;
		}
		
		length++;
	}
	
	
	public void removeFromBeginning()
	{
		if(head == null)
		{
			return;
		}
		
		Node<E> temp = head;
		head = temp.next;
		temp = null;
		length--;
	}
	
	public void removeFromEnd()
	{
		if(tail == null)
		{
			return;
		}
		
		Node<E> temp = tail;
		tail = temp.previous;
		tail.next = null;
		temp = null;
		length--;
	}
	
	
	public void removeAt(int position)
	{
		
		if(head == null)
		{
			return;
		}
		
		if(position < 0)
		{
			position = 0;
		}
		
		if(position >= length)
		{
			position = length -1 ;
		}
		
		if(position == 0)
		{
			removeFromBeginning();
		}
		else if(position == length-1)
		{
			removeFromEnd();
		}
		else
		{
			Node<E> temp = head;
			for(int i = 1; i<position; i++)
			{
				temp = temp.next;
			}
			
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
			temp = null;
		}
		length--;
	}
}
