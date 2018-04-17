package ds.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import ds.linkedlist.Node;

public class BinaryTree<E> {

	public BTNode<E> root;
	private StringBuilder sb = new StringBuilder();
	private int preIndex = 0;

	public BinaryTree() {
		super();
		this.root = null;
	}

	public String inOrderTraversal(BTNode<Integer> root) {

		if (root == null) {
			return "";
		}

		inOrderTraversal(root.left);
		sb.append(root.data).append(" ");
		inOrderTraversal(root.right);
		return sb.toString();
	}

	public String preOrderTraversal(BTNode<Integer> root) {

		if (root == null) {
			return "";
		}

		sb.append(root.data).append(" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		return sb.toString();
	}

	public String postOrderTraversal(BTNode<Integer> root) {

		if (root == null) {
			return "";
		}

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		sb.append(root.data).append(" ");
		return sb.toString();
	}

	public List<E> preOrderTraversalIterative(BTNode<E> root) {

		List<E> list = new ArrayList<>();
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BTNode<E> node = stack.pop();
			list.add(node.data);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return list;
	}

	public String print(List<E> elements) {
		StringBuilder sb = new StringBuilder();
		for (E element : elements) {
			sb.append(element).append(" ");
		}
		return sb.toString();
	}

	public List<E> inOrderTraversalIterative(BTNode<E> root) {
		Stack<BTNode<E>> stack = new Stack<BTNode<E>>();
		List<E> list = new ArrayList<E>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			BTNode<E> temp = stack.pop();
			list.add(temp.data);
			root = temp.right;
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

		}
		return list;
	}

	public String postOrderTraversalIterativeWithTwoStack(BTNode<E> root) {
		if (root == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		Stack<BTNode<E>> s1 = new Stack<BTNode<E>>();
		Stack<BTNode<E>> s2 = new Stack<BTNode<E>>();
		s1.add(root);
		while (!s1.isEmpty()) {
			BTNode<E> temp = s1.pop();
			s2.add(temp);

			if (temp.left != null) {
				s1.add(temp.left);
			}
			if (temp.right != null) {
				s1.add(temp.right);
			}

		}
		while (!s2.isEmpty()) {
			BTNode<E> temp = s2.pop();
			sb.append(temp.data).append(" ");
		}
		return sb.toString();
	}

	public String postOrderTraversalIterativeWithOneStack(BTNode<E> root) {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();

		BTNode<E> prev = null;
		Stack<BTNode<E>> s = new Stack<BTNode<E>>();
		s.add(root);
		while (!s.isEmpty()) {
			BTNode<E> current = s.peek();
			if (prev == null || prev.left == current || prev.right == current) {
				if (current.left != null) {
					s.add(current.left);
				} else if (current.right != null) {
					s.add(current.right);
				} else {
					s.pop();
					sb.append(current.data).append(" ");
				}
			} else if (current.left == prev) {
				if (current.right != null) {
					s.add(current.right);
				} else {
					s.pop();
					sb.append(current.data).append(" ");
				}
			} else if (current.right == prev) {
				s.pop();
				sb.append(current.data).append(" ");
			}

			prev = current;
		}
		return sb.toString();
	}

	public String levelOrderTraversal(BTNode<E> root) {
		if (root == null) {
			return null;
		}
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode<E> temp = q.poll();
			sb.append(temp.data).append(" ");
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		return sb.toString();

	}

	public String inOrderTraversalIterativeMorris(BTNode<E> root) {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		BTNode<E> current = root;
		while (current != null) {
			if (current.left == null) {
				sb.append(current.data).append(" ");
				current = current.right;
			} else {
				// find predecessor
				BTNode<E> pre = current.left;
				while (pre != null && pre != current)
					pre = pre.right;

				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					sb.append(current.data).append(" ");
					current = current.right;
				}
			}
		}
		return sb.toString();
	}

	public String preOrderTraversalIterativeMorris(BTNode<E> root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (root.left == null) {
				sb.append(root.data).append(" ");
				root = root.right;
			} else {
				// finding the predecessor
				BTNode<E> current = root.left;
				while (current.right != null && current.right != root)
					current = current.right;
				// if link is already created remove
				if (current.right == root) {
					current.right = null;
					root = root.right;
				} else {
					sb.append(root.data).append(" ");
					current.right = root;
					root = root.left;
				}
			}
		}
		return sb.toString();
	}

	public Integer maxValue(BTNode<Integer> node) {
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.data;
		int lres = maxValue(node.left);
		int rres = maxValue(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	public Integer maxValueIterative(BTNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int max = Integer.MIN_VALUE;
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.add(root);
		while (!q.isEmpty()) {
			BTNode<Integer> temp = q.poll();
			if (temp.data > max) {
				max = temp.data;
			}

			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
		return max;
	}

	public boolean findInBTRecursive(BTNode<E> root, E data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		return findInBTRecursive(root.left, data)
				|| findInBTRecursive(root.right, data);
	}

	public boolean findInBTIterative(BTNode<E> root2, E data) {
		if (root == null) {
			return false;
		}
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.offer(root2);
		while (!q.isEmpty()) {
			BTNode<E> temp = q.poll();
			if (temp.data == data) {
				return true;
			}
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
		return false;
	}

	public int sizeRecursive(BTNode<E> root) {
		int leftCount = root.left == null ? 0 : sizeRecursive(root.left);
		int rightCount = root.right == null ? 0 : sizeRecursive(root.right);
		return 1 + leftCount + rightCount;
	}

	public int sizeIterative(BTNode<E> root) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.offer(root);
		while (!q.isEmpty()) {
			count++;
			BTNode<E> temp = q.poll();
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}

		}
		return count;
	}

	public int hightRecursive(BTNode<E> root2) {
		if (root2 == null)
			return 0;
		int leftDepth = hightRecursive(root2.left);
		int rightDepth = hightRecursive(root2.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}

	public int hightIterative(BTNode<E> root2) {
		if (root2 == null)
			return 0;
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.offer(root2);
		int hight = 0;

		while (1 == 1) {
			int nodecount = q.size();
			if (nodecount == 0)
				return hight;
			hight++;
			while (nodecount > 0) {
				BTNode<E> temp = q.poll();
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);
				nodecount--;
			}
		}
	}

	void postOrderTraversalFromInorderAndPreorder(int[] in, int[] pre,
			int inStrt, int inEnd) {
		if (inStrt > inEnd) {
			return;
		}

		int inIndex = search(in, inStrt, inEnd, pre[preIndex++]);
		// traverse left tree
		postOrderTraversalFromInorderAndPreorder(in, pre, inStrt, inIndex - 1);
		// traverse right tree
		postOrderTraversalFromInorderAndPreorder(in, pre, inIndex + 1, inEnd);

		// print root node at the end of traversal
		// System.out.print(in[inIndex]+" ");

	}

	int search(int[] in, int startIn, int endIn, int data) {
		int i = 0;
		for (i = startIn; i < endIn; i++) {
			if (in[i] == data) {
				return i;
			}
		}
		return i;
	}

	public String diagonalTraversal(BTNode<Integer> root) {
		StringBuilder sb = new StringBuilder();
		Map<Integer, List<Integer>> levelMap = new HashMap<Integer, List<Integer>>();
		diagonalPrint(root, 0, levelMap);
		for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {

			for (Integer val : entry.getValue()) {

				sb.append(val).append(", ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private void diagonalPrint(BTNode<Integer> root, int level,
			Map<Integer, List<Integer>> levelMap) {
		if (root == null) {
			return;
		}

		List<Integer> list = levelMap.get(level);
		if (list == null) {
			list = new ArrayList<Integer>();
		}
		list.add(root.data);
		levelMap.put(level, list);

		diagonalPrint(root.left, level + 1, levelMap);
		diagonalPrint(root.right, level, levelMap);
	}

	public String verticalOrder(BTNode<Integer> root) {
		StringBuilder sb = new StringBuilder();
		// findMinMax
		findMinMax(root, val, val, 0);
		// print vertical lines
		for (int lineNo = val.min; lineNo <= val.max; lineNo++) {
			printVertical(root, lineNo, 0, sb);
			sb.append("\n");
		}
		return sb.toString();
	}

	private void printVertical(BTNode<Integer> root, int lineNo, int hd,
			StringBuilder sb) {
		if (root == null) {
			return;
		}
		if (hd == lineNo) {
			sb.append(root.data).append(" ");
		}
		printVertical(root.left, lineNo, hd - 1, sb);
		printVertical(root.right, lineNo, hd + 1, sb);

	}

	private void findMinMax(BTNode<Integer> root, Value min, Value max, int hd) {

		if (root == null)
			return;
		if (hd < min.min) {
			min.min = hd;
		}
		if (hd > max.max) {
			max.max = hd;
		}

		findMinMax(root.left, min, max, hd - 1);
		findMinMax(root.right, min, max, hd + 1);
	}

	private Value val = new Value();

	class Value {
		int min, max;
	}

	public boolean leafNodesAreSameOrNot(BTNode<Integer> root1,
			BTNode<Integer> root2) {
		Stack<BTNode<Integer>> s1 = new Stack<BTNode<Integer>>();
		Stack<BTNode<Integer>> s2 = new Stack<BTNode<Integer>>();
		s1.push(root1);
		s2.push(root2);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (s1.isEmpty() || s2.isEmpty()) {
				return false;
			}
			BTNode<Integer> temp1 = s1.pop();
			while (temp1 != null && !temp1.isLeaf()) {
				if (temp1.right != null) {
					s1.push(temp1.right);
				}
				if (temp1.left != null) {
					s1.push(temp1.left);
				}
				temp1 = s1.pop();
			}

			BTNode<Integer> temp2 = s2.pop();
			while (temp2 != null && !temp2.isLeaf()) {
				if (temp2.right != null) {
					s2.push(temp2.right);
				}
				if (temp2.left != null) {
					s2.push(temp2.left);
				}
				temp2 = s2.pop();
			}

			if (temp1 != null && temp2 != null) {
				if (temp1.data != temp2.data) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public String verticalOrderEfficient(BTNode<Integer> root2) {
		// create a map to hold values by level
		Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		int hd = 0;
		getVerticalOrder(root2, hd, map);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			for (Integer data : entry.getValue()) {
				sb.append(data).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private void getVerticalOrder(BTNode<Integer> root2, int hd,
			Map<Integer, List<Integer>> map) {

		if (root2 == null) {
			return;
		}
		List<Integer> list = map.get(hd);
		if (list == null) {
			list = new ArrayList<Integer>();
		}
		list.add(root2.data);
		map.put(hd, list);
		getVerticalOrder(root2.left, hd - 1, map);
		getVerticalOrder(root2.right, hd + 1, map);
	}

	public String printBoundary(BTNode root) {

		StringBuilder sb = new StringBuilder();
		if (root != null) {
			sb.append(root.data).append(" ");
		}
		// printLeft Boundary top down
		printLeftBoundary(root.left, sb);
		// printleft leaf nodes
		printLeaf(root.left, sb);
		// print right leaf nodes
		printLeaf(root.right, sb);
		// print right Boundary bottom up
		printRightBoundary(root.right, sb);
		return sb.toString();
	}

	private void printLeaf(BTNode root, StringBuilder sb) {

		if (root != null) {
			printLeaf(root.left, sb);
			if (root.isLeaf()) {
				sb.append(root.data).append(" ");
			}
			printLeaf(root.right, sb);
		}
	}

	private void printRightBoundary(BTNode root, StringBuilder sb) {

		if (root != null) {
			if (root.right != null) {
				printRightBoundary(root.right, sb);
				sb.append(root.data).append(" ");
			} else if (root.left != null) {
				printRightBoundary(root.left, sb);
				sb.append(root.data).append(" ");
			}
		}
	}

	private void printLeftBoundary(BTNode root, StringBuilder sb) {

		if (root != null) {
			if (root.left != null) {
				sb.append(root.data).append(" ");
				printLeftBoundary(root.left, sb);
			} else if (root.right != null) {
				sb.append(root.right).append(" ");
				printLeftBoundary(root.right, sb);
			}
		}
	}

	public String printSpecificLevelOrder(BTNode<Integer> root) {

		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.data).append(" ");
		if (root.left != null) {
			sb.append(root.left.data).append(" ");
			sb.append(root.right.data).append(" ");
		}
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.add(root.left);
		q.add(root.right);
		while (!q.isEmpty()) {
			BTNode<Integer> first = q.poll();
			BTNode<Integer> second = q.poll();
			sb.append(first.left.data).append(" ");
			sb.append(second.right.data).append(" ");
			sb.append(first.right.data).append(" ");
			sb.append(second.left.data).append(" ");

			if (first.left.left != null) {
				q.offer(first.left);
				q.offer(second.right);
				q.offer(first.right);
				q.offer(second.left);
			}
		}

		return sb.toString();
	}

	public String printSpecificLevelOrder2(BTNode<Integer> root) {

		Stack<BTNode<Integer>> stack = new Stack<BTNode<Integer>>();
		stack.push(root);
		if (root.left != null) {
			stack.push(root.right);
			stack.push(root.left);
		}

		if (root.left.left != null) {
			printSpecificLevelOrderUtil(root, stack);
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop().data).append(" ");
		}
		return sb.toString();
	}

	private void printSpecificLevelOrderUtil(BTNode<Integer> root2,
			Stack<BTNode<Integer>> stack) {

		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.offer(root2.left);
		q.offer(root2.right);
		while (!q.isEmpty()) {
			BTNode<Integer> first = q.poll();
			BTNode<Integer> second = q.poll();

			stack.push(second.left);
			stack.push(first.right);
			stack.push(second.right);
			stack.push(first.left);

			if (first.left.left != null) {
				q.offer(first.right);
				q.offer(second.left);
				q.offer(first.left);
				q.offer(second.right);
			}
		}
	}

	public BTNode buildTreeFromInorderAndLevelOrder(int[] in, int[] level) {
		BTNode startnode = null;
		return constructTree(startnode, level, in, 0, in.length - 1);
	}

	BTNode constructTree(BTNode startNode, int[] levelOrder, int[] inOrder,
			int inStart, int inEnd) {

		// if start index is more than end index
		if (inStart > inEnd)
			return null;

		if (inStart == inEnd)
			return new BTNode(inOrder[inStart]);

		boolean found = false;
		int index = 0;

		// it represents the index in inOrder array of element that
		// appear first in levelOrder array.
		for (int i = 0; i < levelOrder.length - 1; i++) {
			int data = levelOrder[i];
			for (int j = inStart; j < inEnd; j++) {
				if (data == inOrder[j]) {
					startNode = new BTNode(data);
					index = j;
					found = true;
					break;
				}
			}
			if (found == true)
				break;
		}

		// elements present before index are part of left child of startNode.
		// elements present after index are part of right child of startNode.
		startNode.setLeft(constructTree(startNode, levelOrder, inOrder,
				inStart, index - 1));
		startNode.setRight(constructTree(startNode, levelOrder, inOrder,
				index + 1, inEnd));

		return startNode;
	}

	public BTNode<Integer> buildTreeFromLinkedList(Node<Integer> head) {
		BTNode<Integer> node = new BTNode<Integer>(head.data);
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.add(node);
		head = head.next;
		while (head != null) {
			BTNode<Integer> parent = q.poll();
			BTNode<Integer> left = new BTNode<Integer>(head.data);
			q.add(left);
			BTNode<Integer> right = null;
			head = head.next;
			if (head != null) {
				right = new BTNode<Integer>(head.data);
				q.add(right);
				head = head.next;
			}
			parent.left = left;
			parent.right = right;
		}
		return node;
	}

	public BTNode buildTreeFromPreOrderSpecial(int[] pre, char[] preLN, int n,
			BTNode node) {

		int index = 0;

		return constructTreeUtil(pre, preLN, myIndex, n, node);
	}

	BTNode constructTreeUtil(int pre[], char preLN[], Index index_ptr, int n,
			BTNode temp) {
		// store the current value of index in pre[]
		int index = index_ptr.index;

		// Base Case: All nodes are constructed
		if (index == n)
			return null;

		// Allocate memory for this node and increment index for
		// subsequent recursive calls
		temp = new BTNode(pre[index]);
		index_ptr.index++;

		// If this is an internal node, construct left and right subtrees
		// and link the subtrees
		if (preLN[index] == 'N') {
			temp.left = constructTreeUtil(pre, preLN, index_ptr, n, temp.left);
			temp.right = constructTreeUtil(pre, preLN, index_ptr, n, temp.right);
		}

		return temp;
	}

	class Index 
	{
	    int index = 0;
	}
	 Index myIndex = new Index();
}
