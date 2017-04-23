package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;


public class AzLinkedList<E extends Comparable<E> > {

	Node<E> head;
	public void printList()
	{
		Node<E> node = head;
		while(node != null)
		{
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println("\n-----------------");
	}
	
	public String returnList()
	{
		Node<E> node = head;
		StringBuilder sb = new StringBuilder();
		while(node != null)
		{
			sb.append(node.data).append(" ");
			node = node.next;
		}
		return sb.toString();
	}
	
	public synchronized void insertAtBegin(E data)
	{
		Node<E> newNode = new Node<E>(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void insertAfter(Node<E> prevNode,E data)
	{
		if(prevNode == null)
		{
			System.out.println("Previous node is null");
			return;
		}
		Node<E> newNode = new Node<E>(data);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}
	
	public Node<E> getNodeAt(int position)
	{
		Node<E> node = head;
		int i=0;
		while(i != (position-1) && node != null)
		{
			i++;
			node =node.next;
		}
		return node;
	}

	public void insertAtEnd(E data) {
		Node<E> newNode = new Node<E>(data);
		if(head == null)
		{
			head = newNode;
			return;
		}
		Node<E> lastNode = head;
		while(lastNode.next != null)//equal to for(lastNode = head; (q=lastNode.getNext())!= null; lastNode = q); lastNode.setNext(newNode);
		{
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
		
	}
	
	public E removeFromBegin()
	{
		Node<E> temp  = this.head;
		this.head = this.head.next;
		temp.next = null;
		return temp.data;
		
	}
	
	
	public E removeFromEnd()
	{
		if(this.head == null)
		{
			return null;
		}
		Node<E> temp = head;
		Node<E> tail = head;
		Node<E> previous = head;
		if(head.next == null)
		{
			head = null;
			return temp.data;
		}
		
		while((temp = temp.next) != null)
		{
			previous = tail;
			tail = temp;
		}
		
		previous.next = null;
		return tail.data;
	}
	public void deleteNode(E data)
	{
		Node<E> temp = head;
		Node<E> prev = null;
		if(temp.data == data)
		{
			head = temp.next;
			return;
		}
		
		while(temp !=  null && temp.data != data)
		{
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null)
		{
			return;
		}
		
		prev.next = temp.next;
	}
	
	
	public void removeAt(int position)
	{
		if(position == 0)
		{
			head = head.next;
			return;
		}
		
		Node<E> temp = head.next;
		Node<E> prev = head;
		int i =1;
		while(temp != null && i != position)
		{
			prev = temp;
			temp = temp.next;
			i++;
		}
		if(temp == null)
		{
			return;
		}
		prev.next = temp.next;
	}
	
	public E findNthElementFromEnd(int n)
	{
		int length = 0;
		//find length
		Node<E> temp = head;
		while(temp != null)
		{
			temp = temp.next;
			length++;
		}
		
		if(length < n)
		{
			return null;
		}
		
		temp = head;
		for(int i = 1;i<length-n+1;i++)
		{
			temp = temp.next;
		}
		
		return temp.data;
	}
	
	
	public E findNthElementFromEnd2(int n)
	{
		Node<E> p1 = head,p2=null;
		for (int i = 1; i < n; i++) {
			if(p1 != null)
			{
				p1 = p1.next;
			}
		}
		
		while(p1 != null)
		{
			if(p2 == null)
			{
				p2 = head;
			}
			else
			{
				p2 = p2.next;
			}
			p1 = p1.next;
		}
		
		if(p2 != null)
		{
			return p2.data;
		}
		else
		{
			return null;
		}
	}
	
	public Node<E> getHead()
	{
		return head;
	}

	int counter = 0;
	E data = null;
	public E findNthElementFromEnd3(Node<E> head, int n) {
		if(head != null)
		{
			findNthElementFromEnd3(head.next, n);
			counter++;
			if(counter == n)
			{
				data = head.data;
			}
		}
		return data;
	}

	public boolean findLoop(AzLinkedList<E> list) {
		Node<E> fastPtr = list.head;
		Node<E> slowPtr = list.head;
		while(fastPtr != null && fastPtr.next != null)
		{
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr)
			{
				return true;
			}
		}
		return false;
	}

	public Node<E> findBeginOfLoop(AzLinkedList<E> list) {
		Node<E> fastPtr = list.head;
		Node<E> slowPtr = list.head;
		boolean loopExists = false;
		while(fastPtr != null && fastPtr.next != null)
		{
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr)
			{
				loopExists = true;
				break;
			}
		}
		if(loopExists)
		{
			slowPtr = head;
			while(slowPtr != fastPtr)
			{
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
			return fastPtr;
		}
		return null;
	}

	public int getLengthOfLoop(AzLinkedList<E> list) {
		Node<E> fastPtr = list.head;
		Node<E> slowPtr = list.head;
		boolean loopExists = false;
		while(fastPtr != null && fastPtr.next != null)
		{
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if(slowPtr == fastPtr)
			{
				loopExists = true;
				break;
			}
		}
		int length =0 ;
		if(loopExists)
		{
			do{
				slowPtr = slowPtr.next;
				length++;
			}while(slowPtr != fastPtr);
		}
		return length;
	}

	public void insertInSortedLinkedList(E data) {
		Node<E> newNode = new Node<E>(data);
		if(head == null)
		{
			head = newNode;
			return;
		}
		Node<E> current = head;
		Node<E> temp = null;
		while(current != null && current.data.compareTo(data)<=0)
		{
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
		
	}

	public Node<E> reverseLinkedList() {
		
		Node<E> prev = null;
		Node<E> current = head;
		while(current != null)
		{
			Node<E> next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public String printListFromNode(Node<E> revList) {
		Node<E> node = revList;
		StringBuilder sb = new StringBuilder();
		while(node != null)
		{
			sb.append(node.data).append(" ");
			node = node.next;
		}
		return sb.toString();
	}

	public Node<E> findIntersectingNode(Node<E> node, Node<E> node2) {
		int length1=0, length2 =0, diff = 0;
		Node<E> head1 = node, head2= node2;
		while(head1 != null)
		{
			head1 = head1.next;
			length1++;
		}

		while(head2 != null)
		{
			head2 = head2.next;
			length2++;
		}
		
		if(length1 < length2)
		{
			head1 = node2;
			head2 = node;
			diff = length2 - length1;
		}
		else
		{
			head1 = node;
			head2 = node2;
			diff = length1 - length2;
		}
		
		for(int i=0;i<diff;i++)
			head1 = head1.next;
		
		while(head1 != null && head2 != null)
		{
			if(head1 == head2)
				return head1;
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}

	public Node<E> findMiddleNode() {
		//find length
		int length = 0;
		Node<E> temp = head;
		while(temp != null)
		{
			length++;
			temp = temp.next;
		}
		int middle = length/2;
		temp = head;
		for(int i=0;i<middle;i++)
			temp = temp.next;
		return temp;
	}

	public Node<E> findMiddleNode2() {
		Node<E> ptr1 = head, ptr2 = head;
		while(ptr1.next != null)
		{
			ptr2 = ptr2.next;
			ptr1 = ptr1.next.next;
		}
		return ptr2;
	}

	public void reversePair() {
		Node<E> temp = head;
		while(temp != null && temp.next != null)
		{
			E data = temp.data;
			temp.data = temp.next.data;
			temp.next.data = data;
			temp = temp.next.next;
		}
		
	}

	public Node<E> reversePair(Node<E> head) {
		Node<E> temp;
		if(head == null || head.next == null)
		{
			return head;
		}
		else
		{
			temp = head.next;
			head.next = temp.next;
			temp.next = head;
			head = temp;
			head.next.next = reversePair(head.next.next);
			return head;
		}
	}

	public Node<E> mergeSortedList(Node<E> head1,
			Node<E> head2
			) {
		if(head1 == null)
		{
			return head2;
		}
		if(head2 == null)
		{
			return head1;
		}
		Node<E> mergedHead = null;
		if(head1.data.compareTo(head2.data) < 0)
		{
			mergedHead = head1;
			mergedHead.next = mergeSortedList(head1.next, head2);
		}
		else
		{
			mergedHead = head2;
			mergedHead.next = mergeSortedList(head1, head2.next);
		}
		return mergedHead;
	}

	public Node<E> mergeSortedListNonRecursive(Node<E> head1,
			Node<E> head2) {
		Node<E> head = new Node<E>();
		Node<E> temp = head;
		while(head1 != null || head2 != null)
		{
			if(head1 != null && head2 != null)
			{
				if(head1.data.compareTo(head2.data) < 0)
				{
					temp.next = head1;
					head1 = head1.next;
				}
				else
				{
					temp.next = head2;
					head2 = head2.next;
				}
				temp = temp.next;
			}
			else if(head1 == null)
			{
				temp.next = head2;
				break;
			}
			else if(head2 == null)
			{
				temp.next = head1;
				break;
			}
			
		}
		return head.next;
	}

	public Node<E> pairWiseSwap(Node<E> node) {
		
		// If linked list is empty or there is only one node in list
		if (node == null || node.next == null) {
			return null;
		}
		
		// Initialize previous and current pointers
		Node<E> prev = node;
		Node<E> curr = node.next;
		
		node = curr;  // Change head before proceeeding
		
		// Traverse the list
		while (true) {
			Node<E> next = curr.next;
			curr.next = prev; // Change next of current as previous node
			
			// If next NULL or next is the last node
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}
			
			// Change next of previous to next next
			prev.next = next.next;
			
			// Update previous and curr
			prev = next;
			curr = prev.next;
		}
		return node;
	}

	public boolean isPalindrome() {
		//find mid element
		Node<E> fastPtr = head, slowPtr = head, preSlowPtr = null, midNode = null,secondHalf;
		while(fastPtr != null && fastPtr.next != null)
		{
			fastPtr = fastPtr.next.next;
			preSlowPtr = slowPtr;
			slowPtr = slowPtr.next;
		}
		
		//if odd list store the midnode
		if(fastPtr != null)
		{
			midNode = slowPtr;
			slowPtr = slowPtr.next;
		}
		
		//divide 2 parts
		preSlowPtr.next = null;
		secondHalf = slowPtr;
		//reverse the second half
		secondHalf = reverse(secondHalf);
		boolean result = compare(head,secondHalf);
		//reverse second half
		secondHalf = reverse(secondHalf);
		//check midnode
		if(midNode != null)
		{
			preSlowPtr.next = midNode;
			midNode.next = secondHalf;
		}
		else
		{
			preSlowPtr.next = secondHalf;
		}
		return result;
	}

	private boolean compare(Node<E> node1, Node<E> node2) {

		while(node1 != null && node2 != null)
		{
			if(node1.data.equals(node2.data))
			{
				node1 = node1.next;
				node2 = node2.next;
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	public Node<E> reverse(Node<E> startNode) {

		Node<E> previous = null;
		Node<E> current = startNode;
		while(current != null)
		{
			Node<E> nextNode = current.next;
			current.next = previous;
			previous = current;
			current = nextNode;
		}
		return previous;
	}
	
	
	public Node<E> exchangeAdjucentNodes(Node<E> head)
	{
		Node<E> temp = new Node<>();
		temp.next = head;
		Node<E> prev = temp, cur = head;
		while(cur != null && cur.next != null)
		{
			Node<E> tmp = cur.next.next;
			cur.next.next = prev.next;
			prev.next = cur.next;
			cur.next = tmp;
			prev = cur;
			cur = prev.next;
		}
		return temp.next;
	}

	public Node<E> kNodesReverseRecursive(Node<E> head, int k) {
		
		Node<E> current = head;
		Node<E> prev = null;
		Node<E> next = null;
		int count = k;
		//reverse K nodes
		while(count>0 && current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}
		
		if(next != null)
		{
			head.next = kNodesReverseRecursive(next, k);
		}
		return prev;
	}

	public Node<E> kNodesReverseRecursiveAlternatively(Node<E> head, int k) {
		
		Node<E> current = head;
		Node<E> prev = null;
		Node<E> next = null;
		int count = k;
		//reverse K nodes
		while(count>0 && current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}
		
		if(current != null)
		{
			head.next = current;
		}
		
		count =k;
		while(count>1 && current != null)
		{
			current = current.next;
			count--;
		}
		if(current != null)
		{
			current.next = kNodesReverseRecursiveAlternatively(current.next, k);
		}
		return prev;
	}
	
	public Node<E> kNodesReverseNonRecursive(Node<E> headNode, int k) {
		Node<E> startNode = null, endNode = null, nextNode = headNode;
		headNode = null;
		while(nextNode != null)
		{
			startNode = nextNode;
			endNode = nextNode;
			for (int i = 1; i < k; i++) {
				endNode = endNode.next;
				if(endNode == null)
				{
					break;
				}
			}
			
			if(endNode != null)
			{
				nextNode = endNode.next;
				endNode.next = null;
				startNode = reverse(startNode);
			}
			else
			{
				nextNode = null;
			}
			
			if(headNode == null)
			{
				headNode = startNode;
			}
			else {
				getLastNode(headNode).next = startNode;
			}
			
			
			
			
		}
		return headNode;
	}

	public Node<E> getLastNode(Node<E> headNode) {
		Node<E> temp = headNode;
		Node<E> prev = null;
		while(temp != null)
		{
			prev = temp;
			temp =temp.next;
		}
		return prev;
	}

	public void rotateCounterClockwise(int k) {
		int length = this.getLength();
		if(k<=0 || k == length)
			return;
		if(k > length)
		{
			k = length % k;
		}
		//find the kth node
		Node<E> current = head;
		int counter =1;
		while(counter <k && current!= null){
			current = current.next;
			counter++;
		}
		
		if(current == null)
			return;
		Node<E> kthNode = current;
		
		//Find last node
		while(current.next != null)
		{
			current = current.next;
		}
		
		//make the connections last node point to head
		current.next = head;
		head = kthNode.next;
		kthNode.next=null;
	}

	private int getLength() {
		int length = 0;
		Node<E> current = this.head;
		while(current!=null)
		{
			length++;
			current = current.next;
		}
		return length;
	}

	private int getLength(Node<E> node) {
		int length = 0;
		Node<E> current = node;
		while(current!=null)
		{
			length++;
			current = current.next;
		}
		return length;
	}

	public List<Node<E>> splitList(int splitAfter) {
		List<Node<E>> heads = new ArrayList<>();
		Node<E> head1 =head,head2,tmp = head;
		for(int i=1;i<splitAfter;i++)
			tmp = tmp.next;
		head2 = tmp.next;
		tmp.next = null;
		heads.add(head1);
		heads.add(head2);
		return heads;
	}

	public void rotateClockwise(int k) {
		int length = getLength();
		List<Node<E>> heads = splitList(length-k);
		Node<E> head1 = heads.get(0);
		Node<E> head2 = heads.get(1);
		this.head = head2;
		Node<E> lastNode = getLastNode(head2);
		lastNode.next = head1;
		
	}

	public void rotateCounterClockwise2(int k) {
		List<Node<E>> heads = splitList(k);
		Node<E> head1 = heads.get(0);
		Node<E> head2 = heads.get(1);
		this.head = head2;
		Node<E> lastNode = getLastNode(head2);
		lastNode.next = head1;
		
	}

	public Node<Integer> add(Node<Integer> head1, Node<Integer> head2) {
		int carry=0, sum;
		Node<Integer> result = null;
		Node<Integer> prev = null;
		Node<Integer> temp = null;
		while(head1 != null || head2 != null)
		{
			sum = carry + (head1 != null?head1.data:0)+(head2 != null?head2.data:0);
			
			carry = sum>=10?1:0;
			if(sum >= 10)
			{
				sum = sum % 10;
			}
			
			temp = new Node<>(sum);
			
			if(result == null)
			{
				result = temp;
			}
			else
			{
				prev.next = temp;
			}
			prev = temp;
			
			if(head1 != null)
			{
				head1 =head1.next;
			}
			
			if(head2 != null)
			{
				head2 =head2.next;
			}
		}
		
		if(carry > 0)
		{
			temp.next = new Node<>(carry);
		}
		return result;
	}

	public List<Node<E>> alternativeSplit() {
		List<Node<E>> result = new ArrayList<>();
		if(head == null || head.next == null)
		{
			return null;
		}
		Node<E> current = head;
		Node<E> head1 = current;
		Node<E> head2 = current.next;
		while(current != null && current.next != null)
		{
			Node<E> t = current.next;
			current.next = t.next;
			if(current.next != null && current.next.next != null)
			{
				t.next = current.next.next;
			}
			else
			{
				t.next = null;
			}
			
			current = current.next;
		}
		result.add(head1);
		result.add(head2);
		return result;
	}

	public void deleteYNodesAfterXNodes(int x, int y) {

		int length = getLength();
		if(x > length)
		{
			return;
		}
		
		Node<E> n = head;
		while(x >1)
		{
			n = n.next;
			x--;
		}
		
		Node<E> temp = n;
		
		y= y+1;
		while(y>0 && n!=null)
		{
			n = n.next;
			y--;
		}
		
		temp.next = n;
		
	}

	public Node<E> mergeSort(Node<E> a) {
		Node<E> oldHead = a;
		int mid = getLength(a)/2;
		if(a.next == null)
			return a;
		
		while(mid-1>0)
		{
			oldHead =oldHead.next;
			mid--;
		}
		
		Node<E> newHead = oldHead.next;
		
		oldHead.next = null;
		oldHead = a;
		Node<E> t1 = mergeSort(oldHead);
		Node<E> t2 = mergeSort(newHead);
		return mergeList(t1,t2);
	}

	private Node<E> mergeList(Node<E> a, Node<E> b) {
		Node<E> result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data.compareTo(b.data) > 0) {
			result = b;
			result.next = mergeList(a, b.next);
		} else {
			result = a;
			result.next = mergeList(a.next, b);
		}
		return result;
	}

	public List<Node<E>> alternativeMerge(Node<E> head1,
			Node<E> head2) {
		List<Node<E>> results = new ArrayList<Node<E>>();
		Node<E> temp =head1;
		while(head1 != null && head2!=null)
		{
			Node<E> a1 = head1.next;
			Node<E> b1 = head2.next;
			head1.next = head2;
			head2.next = a1;
			head1 = a1;
			head2 = b1;
		}
		results.add(temp);
		if(head1 != null)
		{
			results.add(head1);
		}
		if(head2 != null)
		{
			results.add(head2);
		}
		return results;
	}
}