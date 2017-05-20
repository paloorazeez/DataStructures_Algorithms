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

}
