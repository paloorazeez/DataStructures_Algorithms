package ds.tree;

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
	
	

}
