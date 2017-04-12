package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList<E> {
	
	
	public Node<E> head;
	
	public void insertAtBeginning(E data)
	{
		Node<E> node = new Node<E>(data);
		if(head == null)
		{
			head = node;
			head.next = head;
		}
		else
		{
			node.next = head;
			Node<E> lastNode = head;
			while(lastNode.next != head)
			{
				lastNode = lastNode.next;
			}
			
			lastNode.next = node;
			head = node;
		}
	}
	
	
	public void insertAtEnd(E data)
	{
		Node<E> node = new Node<E>(data);
		if(head == null)
		{
			head = node;
			head.next = head;
		}
		else
		{
			node.next = head;
			Node<E> lastNode = head;
			while(lastNode.next != head)
			{
				lastNode = lastNode.next;
			}
			lastNode.next = node;
		}
		
	}
	
	public void removeFromBeginning()
	{
		if(head == null)
		{
			return;
		}
		else if(head.next == head)
		{
			head = null;
		}
		else
		{
			Node<E> temp = head;
			Node<E> lastNode = head;
			while(lastNode.next != head)
			{
				lastNode = lastNode.next;
			}
			lastNode.next = head.next;
			head = head.next;
			temp = null;
		}
	}
	
	public void removeFromEnd()
	{
		if(head == null)
		{
			return;
		}
		else if(head.next == head)
		{
			head = null;
		}
		else
		{
			Node<E> lastNode = head;
			Node<E> prevNode = head;
			while(lastNode.next != head)
			{
				prevNode = lastNode;
				lastNode = lastNode.next;
			}
			prevNode.next = head;
			lastNode = null;
		}
	}
	
	public void printList()
	{
		Node<E> temp = head;
		do
		{
			System.out.print((temp != null?temp.data:"EMPTY")+" ");
			if (temp != null) {
				temp = temp.next;
			}
		}while(temp != head);
		System.out.println("\n-------------------");
	}

	
	public String returnList(Node<E> head)
	{
		Node<E> temp = head;
		StringBuilder sb = new StringBuilder();
		do
		{
			sb.append(temp != null?temp.data:"EMPTY").append(" ");
			if (temp != null) {
				temp = temp.next;
			}
		}while(temp != head);
		return sb.toString();
	}
	

	public List<Node<E>> split() {
		Node<E> head1,head2;
		Node<E> fastPtr = head, slowPtr = head;
		while(fastPtr.next != head && fastPtr.next.next != head)
		{
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		
		if(fastPtr.next.next == head)
		{
			fastPtr = fastPtr.next;
		}
		head1 = head;
		head2 = slowPtr.next;
		
		fastPtr.next = slowPtr.next;
		slowPtr.next = head;
		List<Node<E>> heads = new ArrayList<>();
		heads.add(head1);
		heads.add(head2);
		return heads;
	}


	public Node<E> getJosephusPosition(Node<E> head, int n, int m) {
		Node<E> p = head;
		for(int count=n;count>1;--count)
		{
			for(int i=0;i<m-1;++i)
				p = p.next;
			System.out.println("Removing: "+p.next.data);
			p.next =p.next.next;
			p = p.next;
		}
		System.out.println("Lucky node:"+p.data);
		return p;
	}

}

