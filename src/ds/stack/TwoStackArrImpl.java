package ds.stack;

public class TwoStackArrImpl {

	private int size;
	private int[] dataArr;
	private int topOne;
	private int topTwo;

	public TwoStackArrImpl(int size) {
		this.size = size;
		this.dataArr = new int[size];
		this.topOne = -1;
		this.topTwo = size;
	}

	public void push(int stackId, int data) throws StackOverflowException {

		if (topOne + 1 == topTwo) {
			throw new StackOverflowException("stack is full");
		}
		if (stackId == 1) {
			dataArr[++topOne] = data;
		} else {
			dataArr[--topTwo] = data;
		}
	}

	public String print(int stackId) {
		StringBuilder sb = new StringBuilder();
		if (stackId == 1) {
			for (int i = topOne; i >= 0; i--) {
				sb.append(dataArr[i]).append(" ");
			}
		} else if (stackId == 2) {
			for (int i = topTwo; i < size; i++) {
				sb.append(dataArr[i]).append(" ");
			}
		}
		return sb.toString();
	}

	public int pop(int stackId) throws StackUnderflowException {

		if (isEmpty(stackId)) {
			throw new StackUnderflowException("Stack is empty");
		}
		if (stackId == 1) {
			return dataArr[topOne--];
		}
		else
		{
			return dataArr[topTwo++];
		}
	}

	public boolean isEmpty(int stackId) {

		if (stackId == 1)
		{
			return (topOne == -1);
		}
		else
		{
			return (topTwo == size);
		}
	}

	public int peek(int stackId) throws StackUnderflowException {
		if(isEmpty(stackId))
		{
			throw new StackUnderflowException("Stack is Empty");
		}
		if(stackId == 1)
		{
			return dataArr[topOne];
		}
		else{
			return dataArr[topTwo];
		}
	}

}
