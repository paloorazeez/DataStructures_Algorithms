package ds.stack;


import org.junit.Assert;
import org.junit.Test;

public class ThreeStackArrImplTest {

	@Test
	public void testPush() throws StackOverflowException
	{
		ThreeStackArrImpl stack = new ThreeStackArrImpl(10);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(3,1);
		stack.push(3,2);
		stack.push(1,11);
		stack.push(1,21);
		stack.push(1,11);
		stack.push(1,21);
		stack.push(2,5);
		stack.push(2,10);
		Assert.assertEquals("21 11 21 11 20 10 ", stack.print(1));
		Assert.assertEquals("10 5 ", stack.print(2));
		Assert.assertEquals("2 1 ", stack.print(3));
	}
	
	@Test
	public void testPushTwo() throws StackOverflowException
	{
		ThreeStackArrImpl stack = new ThreeStackArrImpl(10);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(3,1);
		stack.push(3,2);
		stack.push(3,3);
		stack.push(3,4);
		stack.push(3,5);
		stack.push(1,21);
		stack.push(2,5);
		stack.push(2,10);
		Assert.assertEquals("21 20 10 ", stack.print(1));
		Assert.assertEquals("10 5 ", stack.print(2));
		Assert.assertEquals("5 4 3 2 1 ", stack.print(3));
	}
	@Test
	public void testPop() throws StackOverflowException, StackUnderflowException
	{
		ThreeStackArrImpl stack = new ThreeStackArrImpl(10);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(3,1);
		stack.push(3,2);
		stack.push(3,3);
		stack.push(3,4);
		stack.push(3,5);
		stack.push(1,21);
		stack.push(2,5);
		stack.push(2,10);
		
		Assert.assertEquals(21,stack.pop(1));
		Assert.assertEquals("20 10 ", stack.print(1));
		Assert.assertEquals(10,stack.pop(2));
		Assert.assertEquals("5 ", stack.print(2));
		Assert.assertEquals(5,stack.pop(3));
		Assert.assertEquals("4 3 2 1 ", stack.print(3));
	}
	
	@Test
	public void testPeek() throws StackOverflowException, StackUnderflowException
	{
		ThreeStackArrImpl stack = new ThreeStackArrImpl(10);
		stack.push(1,10);
		stack.push(1,20);
		stack.push(3,1);
		stack.push(3,2);
		stack.push(3,3);
		stack.push(3,4);
		stack.push(3,5);
		stack.push(1,21);
		stack.push(2,5);
		stack.push(2,10);
		
		Assert.assertEquals(21,stack.peek(1));
		Assert.assertEquals("21 20 10 ", stack.print(1));
		Assert.assertEquals(10,stack.peek(2));
		Assert.assertEquals("10 5 ", stack.print(2));
		Assert.assertEquals(5,stack.peek(3));
		Assert.assertEquals("5 4 3 2 1 ", stack.print(3));
		
	}
	
}
