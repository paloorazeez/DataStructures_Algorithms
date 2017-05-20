package ds.stack;

import org.junit.Assert;
import org.junit.Test;

import ds.stack.StackOverflowException;
import ds.stack.StackUnderflowException;
import ds.stack.StaticStack;

public class StaticStackTest {

	@Test
	public void testPush() throws StackOverflowException {
		StaticStack stack = new StaticStack(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		String data = stack.print();
		Assert.assertEquals("4 3 2 1 ", data);
	}
	
	@Test(expected = StackOverflowException.class)
	public void testPushOverflow() throws StackOverflowException {
		StaticStack stack = new StaticStack(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
	}
	
	@Test
	public void testIsFull() throws StackOverflowException
	{
		StaticStack stack = new StaticStack(2);
		stack.push(1);
		stack.push(2);
		Assert.assertTrue(stack.isFull());
	}
	
	
	@Test
	public void testIsFullFalse() throws StackOverflowException
	{
		StaticStack stack = new StaticStack(2);
		stack.push(1);
		Assert.assertFalse(stack.isFull());
	}
	
	@Test
	public void testSize() throws StackOverflowException
	{
		StaticStack stack = new StaticStack(5);
		stack.push(10);
		Assert.assertEquals(1, stack.size());
		
	}
	
	@Test
	public void testIsEmpty()
	{
		StaticStack stack = new StaticStack(1);
		Assert.assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testIsEmptyFalse() throws StackOverflowException
	{
		StaticStack stack = new StaticStack(1);
		stack.push(1);
		Assert.assertFalse(stack.isEmpty());
	}
	
	
	@Test(expected = StackUnderflowException.class)
	public void testPop() throws StackUnderflowException
	{
		StaticStack stack = new StaticStack(10);
		stack.pop();
	}
	
	
	@Test
	public void testPopActual() throws StackUnderflowException, StackOverflowException
	{
		StaticStack stack = new StaticStack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int data = stack.pop();
		Assert.assertEquals(3, data);
		Assert.assertEquals(2, stack.size());
	}
	
	
	@Test(expected = StackUnderflowException.class)
	public void testPeek() throws StackUnderflowException
	{
		
		StaticStack stack = new StaticStack(10);
		stack.peack();
	}
	
	
	@Test
	public void testPeekActual() throws StackUnderflowException, StackOverflowException
	{
		
		StaticStack stack = new StaticStack(10);
		stack.push(10);
		Assert.assertEquals(10, stack.peack());
		Assert.assertEquals(1, stack.size());
	}
	
	
	

}
