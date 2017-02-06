package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeTest {

	public static void main(String[] args) {
		ConcurrentLinkedDeque<Integer> c = new ConcurrentLinkedDeque<Integer>();
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
