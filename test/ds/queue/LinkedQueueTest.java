package ds.queue;

import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {

	@Test
	public void testEnqueue()
	{
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		Assert.assertEquals("10 20 30 40 50 ", queue.print());
	}
	
	@Test
	public void testDequeue() throws QueueUnderflowException
	{
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		Assert.assertEquals(new Integer(10), new Integer(queue.dequeue()));
		Assert.assertEquals("20 30 40 50 ", queue.print());
	}

}
