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
	private BTNode prev;
	BTNode head;

	public BTNode createTreeFromParentRepresentationArray(int[] parent) {
		BTNode[] created = new BTNode[parent.length];
		for(int i=0;i<parent.length;i++)
		{
			created[i] = null;
		}
		
		for(int i = 0;i<parent.length;i++)
			createFromParentRepArrayUtil(parent, i ,created);
		return root;
	}

	private void createFromParentRepArrayUtil(int[] parent, int i,
			BTNode[] created) {

		if(created[i] != null)
		{
			return;
		}
		
		created[i] = new BTNode(i);
		
		if(parent[i] == -1)
		{
			root = created[i];
			return;
		}
		
		//create parent if not there
		if(created[parent[i]] == null)
		{
			createFromParentRepArrayUtil(parent, parent[i], created);
		}
		
		//search parent
		BTNode p = created[parent[i]];
		
		if(p.left == null)
		{
			p.left=created[i];
		}
		else{
			p.right = created[i];
		}
	}

	public BTNode buildTreeFromPostAndInorder(int[] inorder, int[] postOrder) {
		preIndex = inorder.length-1;
		return buildTreeFromPostAndInorderUtil(inorder, postOrder,0,inorder.length-1);
	}

	private BTNode buildTreeFromPostAndInorderUtil(int[] inorder,
			int[] postOrder, int start, int end) {

		if(start > end)
		{
			return null;
		}
		
		BTNode<Integer> node = new BTNode(postOrder[preIndex]);
		preIndex--;
		
		if(start == end)
		{
			return node;
		}
		int index= search(inorder, start, end, node.data);
		node.right = buildTreeFromPostAndInorderUtil(inorder, postOrder, index+1, end);
		node.left = buildTreeFromPostAndInorderUtil(inorder, postOrder, start, index-1);
		return node;
	}

	public BTNode bintree2list(BTNode node) {
		 if (node == null)
	            return node;
	  
	        // Convert to DLL using bintree2listUtil()
	        node = bintree2listUtil(node);
	  
	        // bintree2listUtil() returns root node of the converted
	        // DLL.  We need pointer to the leftmost node which is
	        // head of the constructed DLL, so move to the leftmost node
	        while (node.left != null)
	            node = node.left;
	  
	        return node;
	}

	private BTNode bintree2listUtil(BTNode node) {
		// Base case
        if (node == null)
            return node;
  
        // Convert the left subtree and link to root
        if (node.left != null) 
        {
            // Convert the left subtree
            BTNode left = bintree2listUtil(node.left);
  
            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right != null; left = left.right);
  
            // Make root as next of the predecessor
            left.right = node;
  
            // Make predecssor as previous of root
            node.left = left;
        }
  
        // Convert the right subtree and link to root
        if (node.right != null) 
        {
            // Convert the right subtree
            BTNode right = bintree2listUtil(node.right);
  
            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left != null; right = right.left);
  
            // Make root as previous of successor
            right.left = node;
  
            // Make successor as next of root
            node.right = right;
        }
  
        return node;
	}
	
	void printList(BTNode node) 
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

	public BTNode binaryTree2List2(BTNode root) {
		prev = null;
		fixPreviousLink(root);
		return fixNextLink(root);
	}

	private BTNode fixNextLink(BTNode root) {

		while(root.right != null)
			root = root.right;
		
		while(root != null && root.left != null)
		{
			BTNode left = root.left;
			left.right = root;
			root = root.left;
		}
		return null;
	}

	private void fixPreviousLink(BTNode root) {

		if(root == null)
		{
			return;
		}
		
		fixPreviousLink(root.left);
		root.left = prev;
		prev = root;
		fixPreviousLink(root.right);
	}

	public BTNode binaryTree2List3(BTNode root) {

		if(root == null)
			return null;
		binaryTree2List3(root.left);
		if(prev == null)
		{
			head = root;
		}
		else{
			root.left = prev;
			prev.right = root;
		}
		
		prev = root;
		binaryTree2List3(root.right);
		return head;
	}

	public BTNode binaryTree2List4(BTNode root) {

		if(root == null)
			return null;
		
		binaryTree2List4(root.right);
		root.right = head;
		if(head != null)
		{
			head.left = root;
		}
		
		head = root;
		
		binaryTree2List4(root.left);
		return root;
	}

	public void calculateChildrenSum(BTNode<Integer> root) {

		int leftVal =0, rightVal=0, diff = 0;
		if(root == null || (root.left == null && root.right == null))
			return;
		calculateChildrenSum(root.left);
		calculateChildrenSum(root.right);
		
		if(root.left != null)
			leftVal = root.left.data;
		if(root.right != null)
			rightVal = root.right.data;
		diff = leftVal+rightVal - root.data;
		if(diff > 0)
		{
			root.data = root.data+diff;
		}
		if(diff < 0)
		{
			increment(root, -diff);
		}
	}

	private void increment(BTNode<Integer> root, int diff) {

		if(root.left != null)
		{
			root.left.data = root.left.data + diff;
			increment(root.left, diff);
		}
		else if(root.right != null)
		{
			root.right.data = root.right.data + diff;
			increment(root.right, diff);
		}
	}

	public void convertTreeToThreadedBT(BTNode root) {

		BTNode current = root;
		while(current != null)
		{
			
			if(current.left == null)
			{
				current = current.right;
			}
			else{
				BTNode pre = current.left;
				while(pre != null && pre.right != current && pre.right != null)
					pre = pre.right;
				if(pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}
				else
				{
					current = current.right;
				}
			}
		}
		
	}

	public int toSumTree(BTNode<Integer> root) {

		if(root == null)
			return 0;
		int oldValue = root.data;
		root.data = toSumTree(root.left) + toSumTree(root.right);
		return root.data+oldValue;
	}

	public int toLeftSumTree(BTNode<Integer> root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
		{
			return root.data;
		}
		int leftSum =toLeftSumTree(root.left);
		int rightSum =toLeftSumTree(root.right);
		root.data += leftSum;
		return root.data+rightSum;
	}

	public BTNode mirrorTree(BTNode node) {

		if(node == null)
			return node;
		BTNode left = mirrorTree(node.left);
		BTNode right = mirrorTree(node.right);
		node.left = right;
		node.right = left;
		return node;
	}

	public BTNode bstToBalancedBst(BTNode root) {

		//put nodes into sorted array
		List<BTNode> nodes = new ArrayList<BTNode>();
		storeNodes(nodes, root);
		return bstToBalancedBstUtil(nodes,0,nodes.size()-1);
	}

	private BTNode bstToBalancedBstUtil(List<BTNode> nodes, int start, int end) {
		if(start > end)
		{
			return null;
		}
		//find mid
		int mid = (start+end)/2;
		BTNode node = nodes.get(mid);
		node.left = bstToBalancedBstUtil(nodes, start, mid-1);
		node.right = bstToBalancedBstUtil(nodes, mid+1, end);
		return node;
	}

	private void storeNodes(List<BTNode> nodes, BTNode root) {

		if(root == null)
			return;
		storeNodes(nodes, root.left);
		nodes.add(root);
		storeNodes(nodes, root.right);
	}

	public int findMinHeight(BTNode<E> root2) {
		if(root2 == null)
			return 0;
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.offer(root2);
		q.offer(null);
		int count = 1;
		while(!q.isEmpty())
		{
			BTNode<E> cur = q.poll();
			if(cur != null)
			{
				if(cur.left == null && cur.right == null)
				{
					return count;
				}
				if(cur.left != null)
					q.offer(cur.left);
				if(cur.right != null)
					q.offer(cur.right);
				
			}
			else{
				if (!q.isEmpty()) {
					q.offer(null);
					count++;
				}
			}
		}
		return count;
	}

	public int diameter() {
		Height height = new Height();
		return diamterOpt(this.root,height);
	}
	
	private int diamterOpt(BTNode<E> root, Height height) {
		Height lh = new Height(),rh =new Height();
		if(root == null)
		{
			height.h =0;
			return 0;
		}
		
		int lDiameter = diamterOpt(root.left, lh);
		int rDiameter = diamterOpt(root.right, rh);
		height.h = Math.max(lh.h, rh.h)+1;
		return Math.max(lh.h+rh.h+1, Math.max(lDiameter, rDiameter));
	}

	class Height{
		int h =0;
	}

	public int maxWidth() {
		if(this.root == null)
			return 0;
		int maxWidth = 0;
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.offer(this.root);
		while(!q.isEmpty())
		{
			int count = q.size();
			maxWidth = Math.max(count, maxWidth);
			while(count-- > 0)
			{
				BTNode<E> temp = q.poll();
				if(temp.left != null)
				{
					q.offer(temp.left);
				}
				if(temp.right != null)
				{
					q.offer(temp.right);
				}
			}
					
		}
		return maxWidth;
	}

	public int findLevelMaxSum() {
		Map<Integer, Integer> levelBySum = new HashMap<>();
		int maxSum = 0;
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.offer((BTNode<Integer>) this.root);
		int level = 0;
		while(!q.isEmpty())
		{
			level++;
			int nodeCount = q.size();
			int levelSum = 0;
			while(nodeCount-- >0)
			{
				BTNode<Integer> tmp = q.poll();
				levelSum+= tmp.data;
				if(tmp.left != null)
				{
					q.offer(tmp.left);
				}
				if(tmp.right != null)
				{
					q.offer(tmp.right);
				}
			}
			maxSum = Math.max(levelSum, maxSum);
			levelBySum.put(levelSum, level);
					
		}
		return levelBySum.get(maxSum);
	}
}
