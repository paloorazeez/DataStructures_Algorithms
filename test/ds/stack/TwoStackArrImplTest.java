package ds.stack;

import org.junit.Assert;
import org.junit.Test;

public class TwoStackArrImplTest {

	@Test
	public void testPush() throws StackOverflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(10);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(1,30);
		
		stack.push(2,30);
		stack.push(2,20);
		stack.push(2,10);
		
		Assert.assertEquals("30 20 10 ", stack.print(1));
		Assert.assertEquals("10 20 30 ", stack.print(2));
	}
	
	@Test(expected = StackOverflowException.class)
	public void testPushWithException() throws StackOverflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(5);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(1,30);
		
		stack.push(2,30);
		stack.push(2,20);
		stack.push(2,10);
	}
	
	@Test
	public void testPop() throws StackOverflowException, StackUnderflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(10);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(1,30);

		stack.push(2,30);
		stack.push(2,20);
		stack.push(2,10);

		Assert.assertEquals(30, stack.pop(1));
		Assert.assertEquals(10, stack.pop(2));
		Assert.assertEquals("20 10 ", stack.print(1));
		Assert.assertEquals("20 30 ", stack.print(2));
		
	}
	
	@Test(expected = StackUnderflowException.class)
	public void testPopWithExpception() throws StackOverflowException, StackUnderflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(5);
		stack.push(1,10);
		stack.push(1,20);
		
		stack.push(2,30);
		stack.push(2,20);

		stack.pop(2);
		stack.pop(2);
		stack.pop(2);
		
	}
	
	@Test
	public void testIsEmpty() throws StackOverflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(5);
		stack.push(2, 10);
		Assert.assertTrue(stack.isEmpty(1));
		Assert.assertFalse(stack.isEmpty(2));
	}
	
	@Test
	public void testPeek() throws StackOverflowException, StackUnderflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(5);
		stack.push(1, 2);
		stack.push(1, 4);
		Assert.assertEquals(4, stack.peek(1));
	}
	
	@Test(expected = StackUnderflowException.class)
	public void testPeekWithException() throws StackOverflowException, StackUnderflowException
	{
		TwoStackArrImpl stack = new TwoStackArrImpl(5);
		stack.push(1, 2);
		stack.push(1, 4);
		stack.peek(2);
	}
}
