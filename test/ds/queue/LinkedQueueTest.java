package ds.queue;

import org.junit.Assert;
import org.junit.Test;

import ds.stack.LinkedStack;
import ds.stack.StackUnderflowException;

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
	
	@Test
	public void testReverseQueue() throws QueueUnderflowException, StackUnderflowException
	{
		//Arrange
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		//Act
		queue = queue.reverse();
		//Assert
		Assert.assertEquals("50 40 30 20 10 ", queue.print());
		
	}
	
	
	@Test
	public void testPairwiseOrder() throws StackUnderflowException, QueueUnderflowException
	{
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(4);
		stack.push(6);
		stack.push(7);
		stack.push(-1);
		stack.push(0);
		stack.push(10);
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		Assert.assertTrue(queue.pairwiseOrder(stack));
		Assert.assertEquals("10 0 -1 7 6 4 3 1 2 ",stack.print());
	}
	
	
	@Test
	public void testInterleavingSwap() throws QueueUnderflowException, StackUnderflowException
	{
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		queue.interleavingSwap();
		Assert.assertEquals("6 7 8 9 10  ", queue.print());
	}

}
