package ds.stack;

public class ThreeStackArrImpl {

	private int size;
	private int topOne;
	private int topThree;
	private int baseThree;
	private int topTwo;
	private int[] dataArr;

	public ThreeStackArrImpl(int size) {
		this.size = size;
		this.topOne = -1;
		this.baseThree = size / 2;
		this.topThree = baseThree-1;
		this.topTwo = size;
		this.dataArr = new int[size];
	}

	public void push(int stackId, int data) throws StackOverflowException {

		if (stackId == 1) {
			if (topOne + 1 == baseThree) {
				if (isStack3RightShiftable()) {
					rightShiftStack3();
					dataArr[++topOne] = data;
				} else {
					throw new StackOverflowException("Stack is full");
				}
			} else {
				dataArr[++topOne] = data;
			}
		}

		if (stackId == 2) {
			if (topTwo - 1 == topThree) {
				if (isStack3LeftShiftable()) {
					leftShiftStack3();
					dataArr[--topTwo] = data;
				} else {
					throw new StackOverflowException();
				}
			} else {
				dataArr[--topTwo] = data;
			}
		}

		if (stackId == 3) {
			if (topThree + 1 == topTwo) {
				if (isStack3LeftShiftable()) {
					leftShiftStack3();
					dataArr[++topThree] = data;
				}
			} else {
				dataArr[++topThree] = data;
			}
		}

	}

	private void leftShiftStack3() {

		for(int i = baseThree-1; i<=topThree-1; i++)
		{
			dataArr[i] = dataArr[i+1];
		}
		baseThree--;
		dataArr[topThree--] = 0;
	}

	private boolean isStack3LeftShiftable() {
		return (topOne+1 < baseThree);
	}

	private void rightShiftStack3() {
		for(int i =topThree+1;i>=baseThree;i--)
		{
			dataArr[i] = dataArr[i-1];
		}
		dataArr[baseThree++]=0;
		topThree++;

	}

	private boolean isStack3RightShiftable() {
		return (topThree+1 < topTwo);
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
		else 
		{
			for(int i = topThree;i>=baseThree;i--)
			{
				sb.append(dataArr[i]).append(" ");
			}
		}
		return sb.toString();
	}

	public int pop(int stackId) throws StackUnderflowException {
		if(isEmpty(stackId))
		{
			throw new StackUnderflowException();
		}
		
		if(stackId == 1)
		{
			int top  = dataArr[topOne];
			dataArr[topOne--] = 0;
			return top;
		}
		else if(stackId ==2)
		{
			int top = dataArr[topTwo];
			dataArr[topTwo++] = 0;
			return top;
		}
		else{
			int top = dataArr[topThree];
			dataArr[topThree--] =0;
			return top;
		}
		
	}
	
	
	public int peek(int stackId) throws StackUnderflowException {
		if(isEmpty(stackId))
		{
			throw new StackUnderflowException();
		}
		
		if(stackId == 1)
		{
			int top  = dataArr[topOne];
			return top;
		}
		else if(stackId ==2)
		{
			int top = dataArr[topTwo];
			return top;
		}
		else{
			int top = dataArr[topThree];
			return top;
		}
		
	}

	public boolean isEmpty(int stackId) {

		if(stackId ==1)
		{
			return (topOne == -1);
		}
		else if(stackId == 2)
		{
			return (topOne == size);
		}
		else
		{
			return (topThree == baseThree -1) || (baseThree == size);
		}
	}
}
