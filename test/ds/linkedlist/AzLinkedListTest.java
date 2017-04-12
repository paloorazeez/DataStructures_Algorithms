package ds.linkedlist;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AzLinkedListTest<E> {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindLoop() {
		// arrange
		AzLinkedList<Integer> list = createLoop();
		// action
		boolean flag = list.findLoop(list);
		// assert
		Assert.assertTrue(flag);
	}

	@Test
	public void testFindLoopFalse() {
		// arrange
		AzLinkedList<Integer> list = createList(4);
		// action
		boolean flag = list.findLoop(list);
		// assert
		Assert.assertFalse(flag);
	}

	@Test
	public void testFindBeginOfLoop() {
		// arrange
		AzLinkedList<Integer> list = createLoop();
		// action
		Node<Integer> nodeBegin = list.findBeginOfLoop(list);
		// assert
		Assert.assertEquals(list.getNodeAt(4), nodeBegin);
	}

	@Test
	public void testFindBeginOfLoopFalse() {
		// arrange
		AzLinkedList<Integer> list = createList(4);
		// action
		Node<Integer> nodeBegin = list.findBeginOfLoop(list);
		// assert
		Assert.assertEquals(null, nodeBegin);
	}

	@Test
	public void testGetLengthOfLoop() {
		// arrange
		AzLinkedList<Integer> list = createLoop();
		// action
		int length = list.getLengthOfLoop(list);
		// assert
		Assert.assertEquals(6, length);
	}
	
	
	@Test
	public void testInsertInSortedLinkedList()
	{
		//Arrange
		AzLinkedList<Integer> list = new AzLinkedList<>();
		list.insertInSortedLinkedList(10);
		list.insertInSortedLinkedList(20);
		list.insertInSortedLinkedList(20);
		list.insertInSortedLinkedList(11);
		list.insertInSortedLinkedList(30);
		list.insertInSortedLinkedList(25);
		//Action
		//Assert
		Assert.assertEquals("10 11 20 20 25 30 ", list.returnList());
	}
	
	
	@Test
	public void testReverseLinkedList()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(4);
		//Act
		Node<Integer> revList =  list.reverseLinkedList();
		//Assert
		Assert.assertEquals("4 3 2 1 ",list.printListFromNode(revList));
	}
	
	
	@Test
	public void testFindIntersectingNode()
	{
		//Arrange
		List<Node<Integer>> list = createMergingList();
		//Act
		Node<E> intersectingNode = new AzLinkedList().findIntersectingNode(list.get(0), list.get(1));
		//Assert
		Assert.assertEquals(6, intersectingNode.data);
	}
	
	
	@Test
	public void testFindMiddleNode()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		
		//Act
		Node<Integer> middleNode = list.findMiddleNode();
		//Assert
		Assert.assertTrue((4==middleNode.data));
	}

	@Test
	public void testFindMiddleNode2()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.insertAtEnd(7);
		
		//Act
		Node<Integer> middleNode = list.findMiddleNode2();
		//Assert
		Assert.assertTrue((4==middleNode.data));
	}

	
	@Test
	public void testReversePair()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(5);
		//Act
		list.reversePair();
		//Assert
		Assert.assertEquals("2 1 4 3 5 ", list.returnList());
	}
	
	@Test
	public void testReversePairRecursive()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(5);
		//Act
		Node<Integer> head = list.reversePair(list.head);
		//Assert
		Assert.assertEquals("2 1 4 3 5 ", list.printListFromNode(head));
	}
	
	@Test
	public void testPairSwap()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		Node<Integer> head = list.pairWiseSwap(list.head);
		//Assert
		Assert.assertEquals("2 1 4 3 6 5 ", list.printListFromNode(head));
	}
	
	@Test
	public void testMergeSortedList()
	{
		//Arrange
		AzLinkedList<Integer> list1 = createList(new int[]{1,5,7,8,9});
		AzLinkedList<Integer> list2 = createList(new int[]{2,3,6,8});
		
		//Act
		Node<Integer> mergedHead = list1.mergeSortedList(list1.head, list2.head);

		//Assert
		Assert.assertEquals("1 2 3 5 6 7 8 8 9 ", list1.printListFromNode(mergedHead));
	}
	
	@Test
	public void testMergeSortedListNonRecursive()
	{
		//Arrange
		AzLinkedList<Integer> list1 = createList(new int[]{1,5,7,8,9});
		AzLinkedList<Integer> list2 = createList(new int[]{2,3,6,8});
		
		//Act
		Node<Integer> mergedHead = list1.mergeSortedListNonRecursive(list1.head, list2.head);
		
		//Assert
		Assert.assertEquals("1 2 3 5 6 7 8 8 9 ", list1.printListFromNode(mergedHead));
	}
	
	
	@Test
	public void testIsPalindrome()
	{
		//Arrange
		AzLinkedList<String> list = createList(new String[]{"M","A","L","A","Y","A","L","A","M"});
		//Act
		boolean palindrome = list.isPalindrome();
		//Assert
		Assert.assertTrue(palindrome);
	}
	
	@Test
	public void testReverse()
	{
		//Arrange
		AzLinkedList<String> list = createList(new String[]{"A","B","C","D","E"});
		//Act
		Node<String> reverse = list.reverse(list.head);
		//Assert
		Assert.assertEquals("E D C B A ", list.printListFromNode(reverse));
	}
	
	@Test
	public void testExchangeAdjucentNodes()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(7);
		Node<Integer> temp = list.exchangeAdjucentNodes(list.head);
		Assert.assertEquals("2 1 4 3 6 5 7 ",list.printListFromNode(temp));
	}

	@Test
	public void testKNodesReverseRecursive()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(11);
		//Act
		Node<Integer> revList = list.kNodesReverseRecursive(list.head,3);
		//Assert
		Assert.assertEquals("3 2 1 6 5 4 9 8 7 11 10 ", list.printListFromNode(revList));
	}
	
	@Test
	public void testKNodesReverseNonRecursive()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(11);
		//Act
		Node<Integer> revList = list.kNodesReverseNonRecursive(list.head,3);
		//Assert
		Assert.assertEquals("3 2 1 6 5 4 9 8 7 10 11 ", list.printListFromNode(revList));
	}
	
	@Test
	public void testRotateCounterClockwise()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		list.rotateCounterClockwise(4);
		//Assert
		Assert.assertEquals("5 6 1 2 3 4 ", list.returnList());
		
	}

	@Test
	public void testRotateCounterClockwiseWithNegativeValue()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		list.rotateCounterClockwise(-1);
		//Assert
		Assert.assertEquals("1 2 3 4 5 6 ", list.returnList());
		
	}
	
	@Ignore
	@Test
	public void testRotateCounterClockwiseWithKLargerThanLength()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		list.rotateCounterClockwise(7);
		//Assert
		Assert.assertEquals("6 1 2 3 4 5 ", list.returnList());
		
	}
	
	@Test
	public void testSplitList()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		List<Node<Integer>> heads = list.splitList(2);
		//Assert
		Assert.assertEquals("1 2 ", list.printListFromNode(heads.get(0)));
		Assert.assertEquals("3 4 5 6 ", list.printListFromNode(heads.get(1)));
	}
	
	
	@Test
	public void testRotateClockwise()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		list.rotateClockwise(2);
		//Assert
		Assert.assertEquals("5 6 1 2 3 4 ", list.returnList());
		
	}
	
	@Test
	public void testRotateCounterClockwise2()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(6);
		//Act
		list.rotateCounterClockwise2(4);
		//Assert
		Assert.assertEquals("5 6 1 2 3 4 ", list.returnList());
		
	}
	
	@Test
	public void testAdd()
	{
		//Arrange
		AzLinkedList<Integer> list1 = createList(new int[]{9, 8, 7});
		AzLinkedList<Integer> list2 = createList(new int[]{3, 5, 6});
		//Act
		Node<Integer> result = list1.add(list1.head, list2.head);
		//Assert
		Assert.assertEquals("2 4 4 1 ", list1.printListFromNode(result));
	}
	
	@Test
	public void testAdd2()
	{
		//Arrange
		AzLinkedList<Integer> list1 = createList(new int[]{9, 9, 9});
		AzLinkedList<Integer> list2 = createList(new int[]{1});
		//Act
		Node<Integer> result = list1.add(list1.head, list2.head);
		//Assert
		Assert.assertEquals("0 0 0 1 ", list1.printListFromNode(result));
	}
	
	@Test
	public void testKNodesReverseRecursiveAlternatively()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(11);
		//Act
		Node<Integer> revList = list.kNodesReverseRecursiveAlternatively(list.head,3);
		//Assert
		Assert.assertEquals("3 2 1 4 5 6 9 8 7 10 11 ", list.printListFromNode(revList));
	}
	
	
	@Test
	public void testAlternativeSplit()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(new int[]{1,2,1,2,1});
		//Act
		List<Node<Integer>> result = list.alternativeSplit();
		//Assert
		Assert.assertEquals("1 1 1 ", list.printListFromNode(result.get(0)));
		Assert.assertEquals("2 2 ", list.printListFromNode(result.get(1)));
	}
	
	@Test
	public void testDeleteYNodesAfterXNodes()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(10);
		//Act
		list.deleteYNodesAfterXNodes(3,4);
		//Assert
		Assert.assertEquals("1 2 3 8 9 10 ", list.returnList());
	}
	
	@Test
	public void testMergeSort()
	{
		//Arrange
		AzLinkedList<Integer> list = createList(new int[]{9,3,4,2,5,1});
		//Act
		Node<Integer> result = list.mergeSort(list.head);
		//Assert
		Assert.assertEquals("1 2 3 4 5 9 ", list.printListFromNode(result));
	}
	
	private AzLinkedList<String> createList(String[] strings) {
		AzLinkedList<String> list1 = new AzLinkedList<>();
		for (int i = 0; i < strings.length; i++) {
			list1.insertAtEnd(strings[i]);
		}
		return list1;
	}

	private AzLinkedList<Integer> createList(int[] arr) {
		AzLinkedList<Integer> list1 = new AzLinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			list1.insertAtEnd(arr[i]);
		}
		return list1;
	}
	
	private List<Node<Integer>> createMergingList() {
		Node<Integer> l1 = new Node<Integer>(1);
		Node<Integer> l2 = new Node<Integer>(2);
		Node<Integer> c0 = new Node<Integer>(6);
		Node<Integer> c1 = new Node<Integer>(7);
		Node<Integer> c2 = new Node<Integer>(8);
		
		Node<Integer> r1 = new Node<Integer>(3);
		Node<Integer> r2 = new Node<Integer>(4);
		Node<Integer> r3 = new Node<Integer>(5);
		
		l1.next = l2;
		r1.next = r2;
		r2.next = r3;
		l2.next = c0;
		r3.next = c0;
		c0.next = c1;
		c1.next = c2;
		List<Node<Integer>> list = new ArrayList<>();
		list.add(l1);
		list.add(r1);
		return list;
	}

	private AzLinkedList<Integer> createLoop() {
		AzLinkedList<Integer> list = new AzLinkedList<>();
		list.insertAtBegin(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		Node<Integer> node = list.getNodeAt(4);
		// loop starts
		Node<Integer> l1 = new Node<Integer>(5);
		Node<Integer> r1 = new Node<Integer>(6);
		Node<Integer> l2 = new Node<Integer>(7);
		Node<Integer> r2 = new Node<Integer>(8);
		Node<Integer> c3 = new Node<Integer>(9);

		node.next = l1;
		l1.next = l2;
		l2.next = c3;
		c3.next = r2;
		r2.next = r1;
		r1.next = node;
		return list;
	}

	private AzLinkedList<Integer> createList(int i) {
		AzLinkedList<Integer> list = new AzLinkedList<>();
		list.insertAtBegin(1);
		for (int j = 1; j < i; j++) {
			list.insertAtEnd(j+1);
		}
		return list;
	}

}
