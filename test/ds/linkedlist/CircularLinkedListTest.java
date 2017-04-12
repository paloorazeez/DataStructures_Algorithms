package ds.linkedlist;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class CircularLinkedListTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testSplit() {
		// Arrange
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		createList(list, 8);
		// Act
		List<Node<Integer>> heads = list.split();
		// Assert
		Assert.assertEquals("1 2 3 4 ", list.returnList(heads.get(0)));
		Assert.assertEquals("5 6 7 8 ", list.returnList(heads.get(1)));
	}

	@Test
	public void testGetJosephusPosition() {
		// Arrange
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		createList(list, 7);
		//Act
		Node<Integer> leftNode = list.getJosephusPosition(list.head,7,3);
		//Assert
		Assert.assertTrue(leftNode.data==2);
		
	}

	private void createList(CircularLinkedList<Integer> list, int i) {

		for (int j = 0; j < i; j++) {

			list.insertAtEnd(j + 1);
		}
	}

}
