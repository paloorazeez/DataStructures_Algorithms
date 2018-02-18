package ds.tree;


import org.junit.Assert;
import org.junit.Test;

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
		tree.root.right.right= new BTNode<Integer>(7);
		
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("4 2 5 1 6 3 7 ", tree.print(tree.inOrderTraversalIterative(tree.root)));
	}
	
	
	public void testInorderTraversalIterativeMorris() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(1);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("4 2 5 1 6 3 7 ", tree.inOrderTraversalIterativeMorris(tree.root));
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
		tree.root.right.right= new BTNode<Integer>(7);
		
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("1 2 4 5 3 6 7 ", tree.print(tree.preOrderTraversalIterative(tree.root)));
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("1 2 4 5 3 6 7 ", tree.preOrderTraversalIterativeMorris(tree.root));
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("4 5 2 6 7 3 1 ", tree.postOrderTraversal(tree.root));
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("4 5 2 6 7 3 1 ", tree.postOrderTraversalIterativeWithTwoStack(tree.root));
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("4 5 2 6 7 3 1 ", tree.postOrderTraversalIterativeWithOneStack(tree.root));
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
		tree.root.right.right= new BTNode<Integer>(7);
		
		Assert.assertEquals("1 2 3 4 5 6 7 ", tree.levelOrderTraversal(tree.root));
	}
	
	
	@Test
	public void testMaxValue()
	{
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right= new BTNode<Integer>(7);
		Assert.assertEquals(new Integer(20), tree.maxValue(tree.root));
	}
	
	
	@Test
	public void testMaxValueRecursive()
	{
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.root = new BTNode<Integer>(20);
		tree.root.left = new BTNode<Integer>(2);
		tree.root.right = new BTNode<Integer>(3);
		tree.root.left.left = new BTNode<Integer>(4);
		tree.root.left.left.right = new BTNode<Integer>(10);
		tree.root.left.right = new BTNode<Integer>(5);
		tree.root.right.left = new BTNode<Integer>(6);
		tree.root.right.right= new BTNode<Integer>(7);
		Assert.assertEquals(new Integer(20), tree.maxValueRecursive(tree.root));
	}
}
