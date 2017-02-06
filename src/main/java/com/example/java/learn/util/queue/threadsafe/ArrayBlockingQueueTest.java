package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueTest {
	
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> c = new ArrayBlockingQueue<Integer>(16, true);
		c.add(9);
		c.add(8);
		final Integer dup = 1;
		c.add(dup);
		c.add(dup);
		Integer first = null;
		while ((first = c.poll()) != null) {
			System.out.println(first);
		}

		c.add(null);
	}

}
