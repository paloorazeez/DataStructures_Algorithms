package ds.tree;

public class BTNode<E> {

	public E data;
	public BTNode<E> left, right;
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public BTNode<E> getLeft() {
		return left;
	}
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}
	public BTNode<E> getRight() {
		return right;
	}
	public void setRight(BTNode<E> right) {
		this.right = right;
	}
	public BTNode(E data) {
		super();
		this.data = data;
		this.left = this.right = null;
	}
	
	
}
