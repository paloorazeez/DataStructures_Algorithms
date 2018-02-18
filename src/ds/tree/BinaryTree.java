package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {

	public BTNode<E> root;
	private StringBuilder sb = new StringBuilder();

	public BinaryTree() {
		super();
		this.root = null;
	}

	public String inOrderTraversal(BTNode<Integer> root) {
		
		if(root == null)
		{
			return "";
		}
		
		inOrderTraversal(root.left);
		sb.append(root.data).append(" ");
		inOrderTraversal(root.right);
		return sb.toString();
	}

	public String preOrderTraversal(BTNode<Integer> root) {

		if(root == null)
		{
			return "";
		}
		
		sb.append(root.data).append(" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		return sb.toString();
	}

	public String postOrderTraversal(BTNode<Integer> root) {

		if(root == null)
		{
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
		while(!stack.isEmpty())
		{
			BTNode<E> node = stack.pop();
			list.add(node.data);
			if(node.right != null)
			{
				stack.push(node.right);
			}
			if(node.left != null)
			{
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
			while(root != null)
			{
				stack.push(root);
				root = root.left;
			}
			
			while(!stack.isEmpty())
			{
				BTNode<E> temp = stack.pop();
				list.add(temp.data);
				root = temp.right;
				while(root != null)
				{
					stack.push(root);
					root = root.left;
				}
				
			}
		return list;
	}

	public String postOrderTraversalIterativeWithTwoStack(BTNode<E> root) {
		if(root == null)
		{
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		
		Stack<BTNode<E>> s1 = new Stack<BTNode<E>>();
		Stack<BTNode<E>> s2 = new Stack<BTNode<E>>();
		s1.add(root);
		while(!s1.isEmpty())
		{
			BTNode<E> temp = s1.pop();
			s2.add(temp);
			
			if(temp.left != null)
			{
				s1.add(temp.left);
			}
			if(temp.right != null)
			{
				s1.add(temp.right);
			}
			
		}
		 while (!s2.isEmpty()) 
	        {
	            BTNode<E> temp = s2.pop();
	            sb.append(temp.data).append(" ");
	        }
		return sb.toString();
	}

	public String postOrderTraversalIterativeWithOneStack(BTNode<E> root) {
		if(root == null)
		{
			return null;
		}
		StringBuilder sb = new StringBuilder();
		
		BTNode<E> prev = null;
		Stack<BTNode<E>> s = new Stack<BTNode<E>>();
		s.add(root);
		while(!s.isEmpty())
		{
			BTNode<E> current = s.peek();
			if(prev == null || prev.left == current || prev.right == current)
			{
				if(current.left != null)
				{
					s.add(current.left);
				}
				else if(current.right != null)
				{
					s.add(current.right);
				}
				else
				{
					s.pop();
					sb.append(current.data).append(" ");
				}
			}
			else if(current.left == prev)
			{
				if(current.right != null)
				{
					s.add(current.right);
				}
				else
				{
					s.pop();
					sb.append(current.data).append(" ");
				}
			}
			else if(current.right == prev)
			{
				s.pop();
				sb.append(current.data).append(" ");
			}
			
			prev = current;
		}
		return sb.toString();
	}

	public String levelOrderTraversal(BTNode<E> root) {
		if(root == null)
		{
			return null;
		}
		Queue<BTNode<E>> q = new LinkedList<BTNode<E>>();
		q.add(root);
		while(!q.isEmpty())
		{
			BTNode<E> temp = q.poll();
			sb.append(temp.data).append(" ");
			if(temp.left != null)
			{
				q.add(temp.left);
			}
			if(temp.right != null){
				q.add(temp.right);
			}
		}
		return sb.toString();
		
	}

	public String inOrderTraversalIterativeMorris(BTNode<E> root) {
		if(root == null)
		{
			return null;
		}
		StringBuilder sb = new StringBuilder();
		BTNode<E> current = root;
		while(current != null)
		{
			if(current.left == null)
			{
				sb.append(current.data).append(" ");
				current = current.right;
			}
			else
			{
				//find predecessor
				BTNode<E> pre = current.left;
				while(pre != null && pre != current)
					pre = pre.right;
				
				if(pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}
				else
				{
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
		if(root == null)
		{
			return null;
		}
		while (root != null) {
			if (root.left == null) {
				sb.append(root.data).append(" ");
				root = root.right;
			} else {
				//finding the predecessor
				BTNode<E> current = root.left;
				while (current.right != null && current.right != root)
					current = current.right;
				//if link is already created remove
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

	public Integer maxValueRecursive(BTNode<Integer> root) {
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		
		int max = Integer.MIN_VALUE;
		Queue<BTNode<Integer>> q = new LinkedList<BTNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()){
			BTNode<Integer> temp =   q.poll();
			if(temp.data > max)
			{
				max = temp.data;
			}
			
			if(temp.left != null)
			{
				q.add(temp.left);
			}
			if(temp.right != null)
			{
				q.offer(temp.right);
			}
		}
		return max;
	}
	

}
