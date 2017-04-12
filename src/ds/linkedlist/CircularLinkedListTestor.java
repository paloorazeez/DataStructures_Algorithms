package ds.linkedlist;

public class CircularLinkedListTestor {

	public static void main(String[] args) {

		CircularLinkedList<Integer> cll = new CircularLinkedList<>();
		cll.insertAtBeginning(10);
		cll.printList();
		cll.insertAtBeginning(20);
		cll.printList();
		
		//insert at end
		cll.insertAtEnd(30);
		cll.printList();
		
		//remove from begin
		cll.removeFromEnd();
		cll.printList();
		cll.removeFromEnd();
		cll.printList();
		cll.removeFromEnd();
		cll.printList();
	}

}
