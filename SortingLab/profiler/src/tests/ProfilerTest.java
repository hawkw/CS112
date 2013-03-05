package com.clarkware;

import java.io.*;
import java.util.*;

import junit.framework.*;

/**
 * The <code>ProfilerTest</code> is a <code>TestCase</code>
 * for the <code>Profiler</code> class.
 *
 * @author <a href="mailto:mike@clarkware.com">Mike Clark</a>
 * @author <a href="http://www.clarkware.com">Clarkware Consulting, Inc.</a>
 *
 * @see junit.framework.TestCase
 */

public class ProfilerTest extends TestCase {

	public static final long tolerance = 5;
	 
	/**
	 * Constructs a <code>ProfilerTest</code> with
	 * the specified name.
	 *
	 * @param name Test name.
	 */
	public ProfilerTest(String name) {
		super(name);
	}

	/**
	 * Sets up the test case.
	 * <p>
	 * Called before every test case method.
	 */
	protected void setUp() {
		Profiler.clear();
	}

	/**
	 * Tears down the test case.
	 * <p>
	 * Called after every test case method.
	 */
	protected void tearDown() {
	}
	
	public void testOneSecondExecutionTime() throws Exception {

		long duration = 1000;
		String event = "oneSecond";

		Profiler.begin(event);

		sleep(duration);

		long elapsed = Profiler.end(event);

		assertEquals(duration, elapsed, tolerance);

		Hashtable events = Profiler.getEvents();

		assertEquals(1, events.size());
	}

	public void testOneSecondTwoThreads() throws Exception {

		int count = 2;
		long duration = 1000;
		String event = "oneSecond";

		runThreads(duration, event, count);

		Hashtable events = Profiler.getEvents();
		Profiler.EventProfile e = (Profiler.EventProfile)events.get(event);

		assertEquals(count, e.getCount());
		assertEquals(count * duration, e.getTotalTime(), tolerance * count);
	}

	public void testOneSecondTenThreads() throws Exception {

		int count = 10;
		long duration = 1000;
		String event = "oneSecond";

		runThreads(duration, event, count);

		Hashtable events = Profiler.getEvents();
		Profiler.EventProfile e = (Profiler.EventProfile)events.get(event);

		assertEquals(count, e.getCount());
		assertEquals(count * duration, e.getTotalTime(), tolerance * count + 5);
	}

	public void testReset() throws Exception {

		long duration = 1000;
		String event = "test";

		Profiler.begin(event);

		sleep(duration);

		long elapsed = Profiler.end(event);

		Profiler.reset();

		Hashtable events = Profiler.getEvents();

		assertEquals(1, events.size());
	}

	public void testClear() throws Exception {

		long duration = 1000;
		String event = "test";

		Profiler.begin(event);

		sleep(duration);

		long elapsed = Profiler.end(event);

		Profiler.clear();

		Hashtable events = Profiler.getEvents();

		assertEquals(0, events.size());
	}

	protected void runThreads(long duration, String event, int numThreads) throws Exception {

		Thread[] threads = new Thread[numThreads];

		for (int i=0; i < numThreads; i++) {
			threads[i] = makeDelayThread(duration, event);
		}

		for (int j=0; j < numThreads; j++) {
			threads[j].start();
		}

		for (int k=0; k < numThreads; k++) {
			threads[k].join();
		}
	}

	protected Thread makeDelayThread(final long duration, final String event) 
		throws Exception {

		Thread t = new Thread(new Runnable() {
			public void run() {
				Profiler.begin(event);
				sleep(duration);
				Profiler.end(event);
			}
		});

		return t;
	}

	protected void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Assembles and returns a test suite for all
	 * the test methods of this class.
	 *
	 * @return A non-null <code>Test</code> instance.
	 */
	public static Test suite() {
		TestSuite suite = new TestSuite(ProfilerTest.class);
		return suite;
	}
	
	/**
	 * Main.
	 */
	public static void main(String args[]) {
		String[] testCaseName = {ProfilerTest.class.getName(), "-noloading"};
		//junit.textui.TestRunner.main(testCaseName);
		//junit.ui.TestRunner.main(testCaseName);
		junit.swingui.TestRunner.main(testCaseName);
	}
}
