import static org.junit.Assert.fail;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Random;

import com.hawkw.queuelab.*;

/**
 * Tests for {@link com.hawkw.queuelab.NodeQueue}.
 * 
 * @author Hawk Weisman
 */
@RunWith(JUnit4.class)
public class TestNodeQueue {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	Queue<Integer> intTestQueue;
	Queue<String> stringTestQueue;
	Random random = new Random();

	/**
	 * a basic enqueue/dequeue test
	 */
	@Test
	public void basicEnqueueDequeueTest() {
		try {
			intTestQueue = new NodeQueue<Integer>();
			intTestQueue.enqueue(1);
			intTestQueue.enqueue(2);
			intTestQueue.enqueue(3);
			org.junit.Assert.assertSame("BAD: NodeQueue dequeued wrong item",
					1, intTestQueue.dequeue());
			org.junit.Assert.assertSame("BAD: NodeQueue dequeued wrong item",
					2, intTestQueue.dequeue());
			org.junit.Assert.assertSame("BAD: NodeQueue dequeued wrong item",
					3, intTestQueue.dequeue());

			stringTestQueue = new NodeQueue<String>();
			stringTestQueue.enqueue("Alice");
			stringTestQueue.enqueue("Bob");
			stringTestQueue.enqueue("Charlie");
		} catch (EmptyQueueException e) {
			fail();
		} catch (FullQueueException e) {
			fail();
		}
	}

	/**
	 * tests enqueueing and dequeueing a large number of elements
	 */
	@Test
	public void iterativeEnqueueDequeueTest() {
		try {
			intTestQueue = new NodeQueue<Integer>();
			for (int i = 1; i < 100000; i++) {
				intTestQueue.enqueue(i);
			}
			for (int i = 1; i < 100000; i++) {
				org.junit.Assert.assertTrue(i == intTestQueue.dequeue());
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail();
		}
	}

	/**
	 * tests to see if EmptyQueueExceptions are thrown when expected
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void basicEmptyQueueExceptionTest() throws EmptyQueueException {
		thrown.expect(EmptyQueueException.class);
		intTestQueue = new NodeQueue<Integer>();
		intTestQueue.dequeue();
	}

	/**
	 * tests to see if EmptyQueueExceptions are thrown after
	 * enqueueing/dequeueing multiple items
	 * 
	 * @throws EmptyQueueException
	 * @throws FullQueueException
	 */
	@Test
	public void advancedEmptyQueueExceptionTest() throws EmptyQueueException,
			FullQueueException {
		thrown.expect(EmptyQueueException.class);
		stringTestQueue = new NodeQueue<String>();
		stringTestQueue.enqueue("Alice");
		stringTestQueue.enqueue("Bob");
		stringTestQueue.dequeue();
		stringTestQueue.enqueue("Charlie");
		stringTestQueue.dequeue();
		stringTestQueue.dequeue();
		stringTestQueue.dequeue();
	}

	/**
	 * tests to see if isEmpty() works for an empty queue
	 */
	@Test
	public void basicIsEmptyTest() {
		stringTestQueue = new NodeQueue<String>();
		org.junit.Assert.assertTrue(stringTestQueue.isEmpty());
	}

	/**
	 * tests to see if isEmpty() works after performing multiple
	 * enqueues/dequeues
	 */
	@Test
	public void advancedIsEmptyTest() {
		try {
			stringTestQueue = new NodeQueue<String>();
			stringTestQueue.enqueue("Alice");
			stringTestQueue.enqueue("Bob");
			stringTestQueue.dequeue();
			stringTestQueue.enqueue("Charlie");
			stringTestQueue.dequeue();
			stringTestQueue.dequeue();
		} catch (Exception e) {
			fail();
			e.printStackTrace(System.err);
		}
		org.junit.Assert.assertTrue(stringTestQueue.isEmpty());
	}

	/**
	 * tests to see if size() works
	 */
	@Test
	public void sizeTest() {
		try {
			stringTestQueue = new NodeQueue<String>();
			org.junit.Assert.assertTrue(stringTestQueue.size() == 0);
			stringTestQueue.enqueue("Alice");
			stringTestQueue.enqueue("Bob");
			org.junit.Assert.assertTrue(stringTestQueue.size() == 2);
			stringTestQueue.dequeue();
			org.junit.Assert.assertTrue(stringTestQueue.size() == 1);
			stringTestQueue.enqueue("Charlie");
			stringTestQueue.enqueue("Dave");
			org.junit.Assert.assertTrue(stringTestQueue.size() == 3);

			intTestQueue = new NodeQueue<Integer>();
			org.junit.Assert.assertTrue(intTestQueue.size() == 0);
			intTestQueue.enqueue(1000);
			intTestQueue.enqueue(2000);
			org.junit.Assert.assertTrue(intTestQueue.size() == 2);
			intTestQueue.dequeue();
			org.junit.Assert.assertTrue(intTestQueue.size() == 1);
			intTestQueue.enqueue(3000);
			intTestQueue.enqueue(4000);
			org.junit.Assert.assertTrue(intTestQueue.size() == 3);
		} catch (Exception e) {
			fail();
			e.printStackTrace(System.err);
		}
	}

	/**
	 * tests enqueue/dequeue using random values
	 */
	@Test
	public void randomEnqueueDequeueTest() {
		int a = random.nextInt();
		int b = random.nextInt();
		int c = random.nextInt();
		try {
			intTestQueue = new NodeQueue<Integer>();

			intTestQueue.enqueue(a);
			intTestQueue.enqueue(b);
			intTestQueue.enqueue(c);

			org.junit.Assert.assertTrue(a == intTestQueue.dequeue());
			org.junit.Assert.assertTrue(b == intTestQueue.dequeue());
			org.junit.Assert.assertTrue(c == intTestQueue.dequeue());
		} catch (Exception e) {
			fail();
			e.printStackTrace(System.err);
		}
	}

	/**
	 * tests the front() function
	 */
	@Test
	public void frontTest() {
		try {
			intTestQueue = new NodeQueue<Integer>();

			intTestQueue.enqueue(1230);
			org.junit.Assert.assertTrue(intTestQueue.front() == 1230);
			intTestQueue.enqueue(4290);
			org.junit.Assert.assertTrue(intTestQueue.front() == 1230);
			intTestQueue.dequeue();
			org.junit.Assert.assertTrue(intTestQueue.front() == 4290);
			intTestQueue.enqueue(7280);
			org.junit.Assert.assertTrue(intTestQueue.front() == 4290);

		} catch (Exception e) {
			fail();
			e.printStackTrace(System.err);
		}
	}

	/**
	 * tests the front() function using random values
	 */
	@Test
	public void randomFrontTest() {

		int a = random.nextInt();
		int b = random.nextInt();
		int c = random.nextInt();

		try {
			intTestQueue = new NodeQueue<Integer>();

			intTestQueue.enqueue(a);
			org.junit.Assert.assertTrue(intTestQueue.front() == a);
			intTestQueue.enqueue(b);
			org.junit.Assert.assertTrue(intTestQueue.front() == a);
			intTestQueue.dequeue();
			org.junit.Assert.assertTrue(intTestQueue.front() == b);
			intTestQueue.enqueue(c);
			org.junit.Assert.assertTrue(intTestQueue.front() == b);

		} catch (Exception e) {
			fail();
			e.printStackTrace(System.err);
		}
	}
}
