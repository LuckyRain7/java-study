package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<Integer> c = new ConcurrentLinkedQueue<Integer>();
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
