package ds.stack;

import org.apache.commons.lang3.StringUtils;

import ds.linkedlist.Node;

public class LinkedStack<E> {

	int length;
	Node<E> top;

	public boolean isEmpty() {
		return (length == 0);
	}

	public void push(E data) {

		Node<E> temp = new Node<E>(data);
		temp.next = top;
		top = temp;
		length++;
	}

	public String print() {

		Node<E> temp = top;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.data).append(" ");
			temp = temp.next;
		}
		return sb.toString();
	}

	public E pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException(
					"Stack does not contain any value");
		}
		Node<E> temp = top;
		top = top.next;
		length--;
		return temp.data;
	}

	public int size() {
		return length;
	}

	public E peak() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty");
		}
		return top.data;
	}

	public String convert(String expression) throws StackUnderflowException {

		LinkedStack<Character> stack = new LinkedStack<Character>();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (isAlpha(c)) {
				result.append(c);
			}

			if (c == '(') {
				stack.push(c);
			}
			if (c == ')') {
				char ch;
				while ((ch = stack.pop()) != '(') {
					result.append(ch);
				}

			}

			if (isOperator(c)) {
				if (!stack.isEmpty()) {
					if (precedence(c) > precedence(stack.peak())) {
						stack.push(c);
					} else if (precedence(c) <= precedence(stack.peak())) {
						result.append(stack.pop());
						stack.push(c);
					}
				} else {
					stack.push(c);
				}
			}

		}
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}

	private int precedence(char c) {
		int precedence = 0;
		switch (c) {
		case '+':
			precedence = 1;
			break;
		case '-':
			precedence = 1;
			break;
		case '*':
			precedence = 2;
			break;
		case '/':
			precedence = 2;
			break;
		}
		return precedence;
	}

	private boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}

	private boolean isAlpha(char c) {
		return (c >= 'A' && c <= 'Z' || c >= '0' && c <= '9');
	}

	public boolean evaluate(String expression) throws StackUnderflowException {

		LinkedStack<Character> stack = new LinkedStack<Character>();
		if (StringUtils.isEmpty(expression)) {
			return true;
		}

		for (int i = 0; i < expression.length(); i++) {

			if (expression.charAt(i) == '(' || expression.charAt(i) == '['
					|| expression.charAt(i) == '{') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')'
					|| expression.charAt(i) == ']'
					|| expression.charAt(i) == '}') {
				if (expression.charAt(i) == ')'
						&& (stack.isEmpty() || !stack.peak().equals('('))) {
					return false;
				}
				if (expression.charAt(i) == ']'
						&& (stack.isEmpty() || !stack.peak().equals('['))) {
					return false;
				}
				if (expression.charAt(i) == '}'
						&& (stack.isEmpty() || !stack.peak().equals('{'))) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public int evaluatePostfixExpression(String expression)
			throws StackUnderflowException {
		if (StringUtils.isEmpty(expression)) {
			return 0;
		}

		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (!isOperator(ch)) {
				stack.push(Integer.valueOf(ch + ""));
			} else {
				int a = stack.pop();
				int b = stack.pop();
				int result = compute(b, a, ch);
				stack.push(result);
			}

		}
		return stack.pop();
	}

	private int compute(int a, int b, char ch) {
		switch (ch) {
		case '+':
			return (a + b);
		case '-':
			return (a - b);
		case '*':
			return (a * b);
		case '/':
			return (a / b);
		default:
			return 0;
		}
	}

	public boolean isPalindrome(String string) throws StackUnderflowException {
		if (string.length() % 2 == 0) {
			return false;
		}
		LinkedStack<Character> stack = new LinkedStack<Character>();
		int mid = string.length() / 2;
		for (int i = 0; i < mid; i++) {
			stack.push(string.charAt(i));
		}

		for (int i = mid + 1; i < string.length(); i++) {
			if (string.charAt(i) != stack.pop()) {
				return false;
			}
		}
		return true;
	}

	public int[] calculateSpan(int[] priceArray) {

		int s[] = new int[priceArray.length];
		s[0] = 1;
		for (int i = 1; i < priceArray.length; i++) {
			s[i] = 1;
			for (int j = i - 1; (j >= 0) && priceArray[i] >= priceArray[j]; j--) {
				s[i]++;
			}
		}
		return s;
	}

	public int[] calculateSpanUsingStack(int[] priceArray)
			throws StackUnderflowException {
		int s[] = new int[priceArray.length];
		s[0] = 1;
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(0);

		for (int i = 1; i < priceArray.length; i++) {

			while (!stack.isEmpty()
					&& priceArray[stack.peak()] <= priceArray[i])
				stack.pop();
			s[i] = (stack.isEmpty()) ? i : i - stack.peak();
			stack.push(i);
		}
		return s;
	}

	public int findLargestRectangle(int[] hights)
			throws StackUnderflowException {
		int maxArea = 0;
		int i = 0;
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		while (i < hights.length) {
			if (stack.isEmpty() || hights[i] >= hights[stack.peak()]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				maxArea = Math.max(maxArea, hights[top]
						* (stack.isEmpty() ? i : (i - stack.peak() - 1)));
			}
		}

		while (stack.isEmpty()) {
			int top = stack.pop();
			maxArea = Math.max(maxArea, hights[top]
					* (stack.isEmpty() ? i : (i - stack.peak() - 1)));
		}
		return maxArea;
	}

}
