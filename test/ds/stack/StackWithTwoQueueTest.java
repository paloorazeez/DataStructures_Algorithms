package ds.stack;

import org.junit.Assert;
import org.junit.Test;

import ds.queue.QueueUnderflowException;

public class StackWithTwoQueueTest {
	
	@Test
	public void testStackWithTwoQueue() throws QueueUnderflowException
	{
		StackWithTwoQueue<Integer> stack = new StackWithTwoQueue<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		Assert.assertEquals(new Integer(40), new Integer(stack.pop()));
	}

}
