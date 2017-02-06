package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
	
	public static void main(String[] args) {
		PriorityBlockingQueue<Integer> c = new PriorityBlockingQueue<Integer>();
		c.add(9);
		c.add(8);
		c.add(1);
		Integer first = null;
		while ((first = c.poll()) != null) {
			System.out.println(first);
		}

		c.add(null);
	}

}
