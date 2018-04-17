package ds.tree;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import ds.linkedlist.AzLinkedList;

public class BinaryTreeTest {

	@Test
	public void testInorderTraversal() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("4 2 5 1 6 3 7 ", tree.inOrderTraversal(tree.root));
	}

	@Test
	public void testInorderTraversalIterative() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("4 2 5 1 6 3 7 ",
				tree.print(tree.inOrderTraversalIterative(tree.root)));
	}

	public void testInorderTraversalIterativeMorris() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("4 2 5 1 6 3 7 ",
				tree.inOrderTraversalIterativeMorris(tree.root));
	}

	@Test
	public void testPreorderTraversal() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("1 2 4 5 3 6 7 ", tree.preOrderTraversal(tree.root));
	}

	@Test
	public void testPreorderTraversalIterative() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("1 2 4 5 3 6 7 ",
				tree.print(tree.preOrderTraversalIterative(tree.root)));
	}

	@Test
	public void testPreorderTraversalIterativeMorris() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("1 2 4 5 3 6 7 ",
				tree.preOrderTraversalIterativeMorris(tree.root));
	}

	@Test
	public void testPostorderTraversal() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("4 5 2 6 7 3 1 ",
				tree.postOrderTraversal(tree.root));
	}

	@Test
	public void testPostorderTraversalIterativeWithTwoStack() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("4 5 2 6 7 3 1 ",
				tree.postOrderTraversalIterativeWithTwoStack(tree.root));
	}

	@Test
	public void testPostorderTraversalIterativeWithOneStack() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("4 5 2 6 7 3 1 ",
				tree.postOrderTraversalIterativeWithOneStack(tree.root));
	}

	@Test
	public void testLevelOrderTraversal() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);

		Assert.assertEquals("1 2 3 4 5 6 7 ",
				tree.levelOrderTraversal(tree.root));
	}

	@Test
	public void testMaxValue() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertEquals(new Integer(20), tree.maxValue(tree.root));
	}

	@Test
	public void testMaxValueIterative() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertEquals(new Integer(20), tree.maxValueIterative(tree.root));
	}

	@Test
	public void testFindInBTRecursive() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertTrue(tree.findInBTRecursive(tree.root, 7));
	}

	@Test
	public void testFindInBTIterative() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		// Assert.assertTrue(tree.findInBTIterative(tree.root, 7));
	}

	@Test
	public void testSizeIterative() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertEquals(8, tree.sizeIterative(tree.root));
	}

	@Test
	public void testSizeRecursive() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertEquals(8, tree.sizeRecursive(tree.root));
	}

	@Test
	public void testHightRecursive() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertEquals(4, tree.hightRecursive(tree.root));
	}

	@Test
	public void testHightIterative() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		Assert.assertEquals(4, tree.hightIterative(tree.root));
	}

	@Test
	public void testPostOrderTraversal() {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		int len = in.length;

		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.postOrderTraversalFromInorderAndPreorder(in, pre, 0, len - 1);

	}

	@Ignore
	@Test
	public void testDiagonalTraversal() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(8);
		tree.root.left = new BTNode<Integer>(3);
		tree.root.right = new BTNode<Integer>(10);
		tree.root.left.left = new BTNode<Integer>(1);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(14);
		tree.root.right.left.left = new BTNode<Integer>(4);
		tree.root.right.left.right = new BTNode<Integer>(7);
		tree.root.right.right.left = new BTNode<Integer>(3);
		Assert.assertEquals("8, 10, 14, \n3, 6, 7, 3, \n1, 4, ",
				tree.diagonalTraversal(tree.root));
	}

	@Ignore
	@Test
	public void testverticalOrder() {
		BinaryTree<Integer> tree = new BinaryTree<>();

		/* Let us construct the tree shown in above diagram */
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		tree.root.right.left.right = new BTNode<Integer>(8);
		tree.root.right.right.right = new BTNode<Integer>(9);
		Assert.assertEquals("4 \n2 \n1 5 6 \n3 8 \n7 \n9 ",
				tree.verticalOrder(tree.root));
	}

	@Test
	public void testLeafNodesAreSameOrNot() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		BTNode<Integer> root1 = new BTNode<Integer>(1);
		root1.left = new BTNode<Integer>(2);
		root1.right = new BTNode<Integer>(3);
		root1.left.left = new BTNode<Integer>(4);
		root1.right.left = new BTNode<Integer>(6);
		root1.right.right = new BTNode<Integer>(7);

		BTNode<Integer> root2 = new BTNode<Integer>(0);
		root2.left = new BTNode<Integer>(1);
		root2.right = new BTNode<Integer>(5);
		root2.left.right = new BTNode<Integer>(4);
		root2.right.left = new BTNode<Integer>(6);
		root2.right.right = new BTNode<Integer>(7);
		
		Assert.assertTrue(tree.leafNodesAreSameOrNot(root1, root2));
	}

	@Ignore
	@Test
	public void testverticalOrderEfficient() {
		BinaryTree<Integer> tree = new BinaryTree<>();

		/* Let us construct the tree shown in above diagram */
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		tree.root.right.left.right = new BTNode<Integer>(8);
		tree.root.right.right.right = new BTNode<Integer>(9);
		Assert.assertEquals("4 \n2 \n1 5 6 \n3 8 \n7 \n9 ",
				tree.verticalOrderEfficient(tree.root));
	}
	
	@Test
	public void testBoundaryTraversal()
	{
		BinaryTree tree = new BinaryTree();
        tree.root = new BTNode<Integer>(20);
        tree.root.left = new BTNode<Integer>(8);
        tree.root.left.left = new BTNode<Integer>(4);
        tree.root.left.right = new BTNode<Integer>(12);
        tree.root.left.right.left = new BTNode<Integer>(10);
        tree.root.left.right.right = new BTNode<Integer>(14);
        tree.root.right = new BTNode<Integer>(22);
        tree.root.right.right = new BTNode<Integer>(25);
        Assert.assertEquals("20 8 4 10 14 25 22 ",tree.printBoundary(tree.root));
	}
	
	@Test
	public void testSpecificLevelOrderTraversalOnPerfectBT()
	{
		BinaryTree tree = new BinaryTree();
        tree.root = new BTNode<Integer>(1);
        tree.root.left = new BTNode<Integer>(2);
        tree.root.right = new BTNode<Integer>(3);
  
        tree.root.left.left = new BTNode<Integer>(4);
        tree.root.left.right = new BTNode<Integer>(5);
        tree.root.right.left = new BTNode<Integer>(6);
        tree.root.right.right = new BTNode<Integer>(7);
  
        tree.root.left.left.left = new BTNode<Integer>(8);
        tree.root.left.left.right = new BTNode<Integer>(9);
        tree.root.left.right.left = new BTNode<Integer>(10);
        tree.root.left.right.right = new BTNode<Integer>(11);
        tree.root.right.left.left = new BTNode<Integer>(12);
        tree.root.right.left.right = new BTNode<Integer>(13);
        tree.root.right.right.left = new BTNode<Integer>(14);
        tree.root.right.right.right = new BTNode<Integer>(15);
  
        tree.root.left.left.left.left = new BTNode<Integer>(16);
        tree.root.left.left.left.right = new BTNode<Integer>(17);
        tree.root.left.left.right.left = new BTNode<Integer>(18);
        tree.root.left.left.right.right = new BTNode<Integer>(19);
        tree.root.left.right.left.left = new BTNode<Integer>(20);
        tree.root.left.right.left.right = new BTNode<Integer>(21);
        tree.root.left.right.right.left = new BTNode<Integer>(22);
        tree.root.left.right.right.right = new BTNode<Integer>(23);
        tree.root.right.left.left.left = new BTNode<Integer>(24);
        tree.root.right.left.left.right = new BTNode<Integer>(25);
        tree.root.right.left.right.left = new BTNode<Integer>(26);
        tree.root.right.left.right.right = new BTNode<Integer>(27);
        tree.root.right.right.left.left = new BTNode<Integer>(28);
        tree.root.right.right.left.right = new BTNode<Integer>(29);
        tree.root.right.right.right.left = new BTNode<Integer>(30);
        tree.root.right.right.right.right = new BTNode<Integer>(31);
  
        Assert.assertEquals("1 2 3 4 7 5 6 8 15 9 14 10 13 11 12 16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24 ",
        		tree.printSpecificLevelOrder(tree.root));
	}

	@Test
	public void testSpecificLevelOrderTraversalOnPerfectBT2()
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right = new BTNode<Integer>(7);
		
		tree.root.left.left.left = new BTNode<Integer>(8);
		tree.root.left.left.right = new BTNode<Integer>(9);
		tree.root.left.right.left = new BTNode<Integer>(10);
		tree.root.left.right.right = new BTNode<Integer>(11);
		tree.root.right.left.left = new BTNode<Integer>(12);
		tree.root.right.left.right = new BTNode<Integer>(13);
		tree.root.right.right.left = new BTNode<Integer>(14);
		tree.root.right.right.right = new BTNode<Integer>(15);
		
		tree.root.left.left.left.left = new BTNode<Integer>(16);
		tree.root.left.left.left.right = new BTNode<Integer>(17);
		tree.root.left.left.right.left = new BTNode<Integer>(18);
		tree.root.left.left.right.right = new BTNode<Integer>(19);
		tree.root.left.right.left.left = new BTNode<Integer>(20);
		tree.root.left.right.left.right = new BTNode<Integer>(21);
		tree.root.left.right.right.left = new BTNode<Integer>(22);
		tree.root.left.right.right.right = new BTNode<Integer>(23);
		tree.root.right.left.left.left = new BTNode<Integer>(24);
		tree.root.right.left.left.right = new BTNode<Integer>(25);
		tree.root.right.left.right.left = new BTNode<Integer>(26);
		tree.root.right.left.right.right = new BTNode<Integer>(27);
		tree.root.right.right.left.left = new BTNode<Integer>(28);
		tree.root.right.right.left.right = new BTNode<Integer>(29);
		tree.root.right.right.right.left = new BTNode<Integer>(30);
		tree.root.right.right.right.right = new BTNode<Integer>(31);
		
		Assert.assertEquals("16 31 17 30 18 29 19 28 20 27 21 26 22 25 23 24 8 15 9 14 10 13 11 12 4 7 5 6 2 3 1 ",
				tree.printSpecificLevelOrder2(tree.root));
	}
	
	@Test
	public void testBuildTreeFromInorderAndLevelOrder()
	{
        BinaryTree tree = new BinaryTree();
        int in[] = new int[]{4, 8, 10, 12, 14, 20, 22};
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14};
        int n = in.length;
        BTNode node = tree.buildTreeFromInorderAndLevelOrder(in, level);
  
        /* Let us test the built tree by printing Inorder traversal */
        Assert.assertEquals("4 8 10 12 14 20 22 ", tree.inOrderTraversal(node));

	}
	
	@Test
	public void testBuildTreeFromLinkedList()
	{
		BinaryTree<Integer> tree = new BinaryTree();
		AzLinkedList<Integer> ll = createList(new int[]{10,12,15,25,30,36});
		BTNode<Integer> root = tree.buildTreeFromLinkedList(ll.getHead());
		Assert.assertEquals("25 12 30 10 36 15 ", tree.inOrderTraversal(root));
	}
	
	private AzLinkedList<Integer> createList(int[] arr) {
		AzLinkedList<Integer> list1 = new AzLinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			list1.insertAtEnd(arr[i]);
		}
		return list1;
	}
	
	@Test
	public void testBuildTreeFromPreOrderSpecial()
	{
		BinaryTree tree = new BinaryTree();
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        int n = pre.length;
  
        // construct the above tree
        BTNode mynode = tree.buildTreeFromPreOrderSpecial(pre, preLN, n, tree.root);
  
        // Test the constructed tree
        Assert.assertEquals("20 30 5 10 15 ", tree.inOrderTraversal(mynode));

		
	}
}
