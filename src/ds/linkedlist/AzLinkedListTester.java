package ds.linkedlist;




public class AzLinkedListTester {

	public static void main(String[] args) {
		AzLinkedList<Integer> ll = new AzLinkedList<>();
		ll.insertAtBegin(1);
		ll.insertAtBegin(2);
		ll.insertAtBegin(3);
		ll.insertAtBegin(4);
		ll.printList();
		ll.insertAfter(ll.getNodeAt(2), 6);
		ll.printList();
		ll.insertAtEnd(7);
		ll.printList();
		System.out.println(ll.findNthElementFromEnd(3));
		System.out.println(ll.findNthElementFromEnd2(3));
		System.out.println(ll.findNthElementFromEnd3(ll.getHead(),3));
		
		/*ll.deleteNode(7);
		ll.printList();
		
		ll.removeAt(2);
		ll.printList();
		
		ll.removeFromBegin();
		ll.printList();
		
		ll.removeFromEnd();
		ll.printList();
		ll.removeFromEnd();
		ll.printList();
		ll.removeFromEnd();
		ll.printList();*/

	}

}
