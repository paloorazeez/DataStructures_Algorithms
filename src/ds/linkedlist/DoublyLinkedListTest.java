package ds.linkedlist;

public class DoublyLinkedListTest {

	public static void main(String[] args) {

		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		
		//insertion at beginning
		dll.insertAtBegining(1);
		dll.insertAtBegining(2);
		dll.printList(false);
		//insertion at the end
		dll.insertAtEnd(3);
		dll.insertAtEnd(4);
		dll.printList(false);
		dll.printHead(false);
		dll.printTail(false);
		
		
		//insertion at the middle
		dll.insertAt(5, 5);
		dll.printList(false);
		dll.printHead(false);
		dll.printTail(false);
		
		//remove from start
		/*dll.removeFromBeginning();
		dll.printList(false);
		dll.printHead(false);
		dll.printTail(false);
		
		dll.removeFromEnd();
		dll.printList(false);
		dll.printTail(true);
		dll.printLength();*/
		
		//remove from middle
		dll.removeAt(3);
		dll.printList(false);
		dll.printLength();
		
		dll.removeAt(0);
		dll.printList(false);
		dll.printHead(false);
		
		
		
	}

}
