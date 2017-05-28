package ds.stack;

import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {

	@Test
	public void testIsEmpty() {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		Assert.assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(100);
		Assert.assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testPush()
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(10);
		stack.push(20);
		Assert.assertEquals("20 10 ", stack.print());
		
	}
	
	@Test
	public void testPop() throws StackUnderflowException
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		Assert.assertEquals(new Integer(30), new Integer(stack.pop()));
		Assert.assertEquals(2, stack.size());
		
	}
	
	@Test(expected = StackUnderflowException.class)
	public void testPopEmpty() throws StackUnderflowException
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.pop();
		
	}
	
	

	@Test
	public void testPeak() throws StackUnderflowException
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		Assert.assertEquals(new Integer(30), new Integer(stack.peak()));
		Assert.assertEquals(3, stack.size());
		
	}
	
	@Test(expected = StackUnderflowException.class)
	public void testPeakEmpty() throws StackUnderflowException
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.peak();
		
	}
	
	
	@Test
	public void testConvert() throws StackUnderflowException
	{
		LinkedStack<Void> converter = new LinkedStack();
		String postfixExpression = converter.convert("A*B-(C+D)+E");
		Assert.assertEquals("AB*CD+-E+",postfixExpression);
	}
	
	@Test
	public void testConvert2() throws StackUnderflowException
	{
		LinkedStack<Void> converter = new LinkedStack();
		String postfixExpression = converter.convert("(A*(B+(C/D)))");
		Assert.assertEquals("ABCD/+*",postfixExpression);
	}
	
	
	
	@Test
	public void testEvaluate() throws StackUnderflowException
	{
		LinkedStack<Void> balancer = new LinkedStack<Void>();
		Assert.assertTrue(balancer.evaluate("(A+B)+(C+D)"));
	}
	
	@Test
	public void testEvaluateFalse() throws StackUnderflowException
	{
		LinkedStack<Void> balancer = new LinkedStack<Void>();
		Assert.assertFalse(balancer.evaluate("((A+B)+(C+D)"));
	}
	
	@Test
	public void testEvaluateFalse2() throws StackUnderflowException
	{
		LinkedStack<Void> balancer = new LinkedStack<Void>();
		Assert.assertFalse(balancer.evaluate("](A+B)+(C+D)"));
	}
	@Test
	public void testEvaluateFalse3() throws StackUnderflowException
	{
		LinkedStack<Void> balancer = new LinkedStack<Void>();
		Assert.assertTrue(balancer.evaluate("A+B+C+D"));
	}
	
	@Test
	public void testEvaluatePostfixExpression() throws StackUnderflowException
	{
		LinkedStack<Integer> balancer = new LinkedStack<Integer>();
		Assert.assertEquals(2,balancer.evaluatePostfixExpression("123*+5-"));
	}
	
	@Test
	public void testIsPlaindrome() throws StackUnderflowException
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		Assert.assertTrue(stack.isPalindrome("malayalam"));
	}
	
	@Test
	public void testIsPlaindromeEven() throws StackUnderflowException
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		Assert.assertFalse(stack.isPalindrome("malayalam1"));
	}
	@Test
	public void testIsPlaindromeFalse() throws StackUnderflowException
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		Assert.assertFalse(stack.isPalindrome("malayalan"));
	}
	
	@Test
	public void testCalculateSpan()
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		int result[] = stack.calculateSpan(new int[]{6,3,4,5,2});
		Assert.assertArrayEquals(new int[]{1,1,2,3,1}, result);
	}
	
	@Test
	public void testCalculateSpanUsingStack() throws StackUnderflowException
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		int result[] = stack.calculateSpanUsingStack(new int[]{6,3,4,5,2});
		Assert.assertArrayEquals(new int[]{1,1,2,3,1}, result);
	}
	
	@Test
	public void testFindLargestRectangle() throws StackUnderflowException
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		Assert.assertEquals(12,stack.findLargestRectangle(new int[]{6,2,5,4,5,1,6}));
	}
	
	@Test
	public void testFindLargestRectangleTwo() throws StackUnderflowException
	{
		LinkedStack<Void> stack = new LinkedStack<Void>();
		Assert.assertEquals(10,stack.findLargestRectangle(new int[]{3,2,5,6,1,4,4}));
	}
	
	@Test
	public void testSort() throws StackUnderflowException
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(10);
		stack.push(1);
		stack.push(11);
		stack.push(4);
		stack.push(6);
		stack.push(2);
		stack.push(5);
		stack = stack.sort();
		Assert.assertEquals("1 2 4 5 6 10 11 ", stack.print());
	}

}
