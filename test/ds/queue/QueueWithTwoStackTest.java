package ds.queue;


import org.junit.Assert;
import org.junit.Test;

import ds.stack.StackUnderflowException;

public class QueueWithTwoStackTest {
	
	@Test
	public void testQueueWithTwoStack() throws StackUnderflowException
	{
		QueueWithTwoStack<Integer> queue = new QueueWithTwoStack<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		Assert.assertEquals(new Integer(10), new Integer(queue.dequeue()));
		queue.enqueue(40);
		queue.enqueue(50);
		Assert.assertEquals(new Integer(20), new Integer(queue.dequeue()));
		Assert.assertEquals(new Integer(30), new Integer(queue.dequeue()));
		Assert.assertEquals(new Integer(40), new Integer(queue.dequeue()));
		Assert.assertEquals(new Integer(50), new Integer(queue.dequeue()));
		
	}

}
