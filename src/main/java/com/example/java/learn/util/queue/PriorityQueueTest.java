package com.example.java.learn.util.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> c = new PriorityQueue<Integer>();
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
