package com.example.java.learn.util;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> c = new PriorityQueue<Integer>();
		c.add(9);
		c.add(8);
		final Integer dup = 1;
		c.add(dup);
		c.add(dup);
		Integer first = null;
		while ((first = c.remove()) != null) {
			System.out.println(first);
		}

		c.add(null);
	}

}
