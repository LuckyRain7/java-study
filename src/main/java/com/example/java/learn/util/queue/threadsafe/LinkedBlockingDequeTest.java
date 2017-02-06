package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeTest {
	
	public static void main(String[] args) {
		LinkedBlockingDeque<Integer> c = new LinkedBlockingDeque<Integer>();
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
