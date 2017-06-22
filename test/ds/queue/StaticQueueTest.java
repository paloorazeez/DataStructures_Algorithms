package ds.queue;


import org.junit.Assert;
import org.junit.Test;

public class StaticQueueTest {
	
	@Test
	public void testEnQueue() throws QueueOverflowException
	{
		StaticQueue queue = new StaticQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		Assert.assertEquals("10 20 30 40 50 ", queue.print());
	}
	
	
	@Test
	public void testDequeue() throws QueueOverflowException, QueueUnderflowException
	{
		StaticQueue queue = new StaticQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		Assert.assertEquals(10, queue.dequeue());
		Assert.assertEquals("20 30 40 50 ", queue.print());
		
	}
	
	@Test
	public void testDequeueComplex() throws QueueOverflowException, QueueUnderflowException
	{
		StaticQueue queue = new StaticQueue(5);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		Assert.assertEquals(10, queue.dequeue());
		Assert.assertEquals(20, queue.dequeue());
		Assert.assertEquals(30, queue.dequeue());
		Assert.assertEquals("40 50 ", queue.print());
		queue.enqueue(60);
		queue.enqueue(70);
		queue.enqueue(80);
		Assert.assertEquals("40 50 60 70 80", queue.print());
		
	}

}
