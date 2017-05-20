package ds.stack;


public class StaticStack {

	
	final int[] stackArr;
	private int top =-1;
	public StaticStack(int size) {
		stackArr = new int[size];
	}

	public void push(int data) throws StackOverflowException {
		if(isFull())
		{
			throw new StackOverflowException("Max stack size is filled. Size:"+this.size());
		}
		
		stackArr[++top] = data;
		
	}

	public String print() {
		StringBuilder sb = new StringBuilder();
		for(int i = size()-1;i>=0;i--)
		{
			sb.append(stackArr[i]).append(" ");
		}
		return sb.toString();
	}

	public boolean isFull() {
		return (top==stackArr.length-1);
	}

	public int size() {
		return top +1;
	}

	public boolean isEmpty() {
		return (top==-1);
	}

	public int pop() throws StackUnderflowException {

		if(isEmpty())
		{
			throw new StackUnderflowException("No values to return");
		}
		return stackArr[top--];
	}

	public int peack() throws StackUnderflowException {
		if(isEmpty())
		{
			throw new StackUnderflowException("No values to return");
		}
		return stackArr[top];
	}

}
