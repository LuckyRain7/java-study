package com.example.java.learn.util.queue;

import java.util.ArrayDeque;

public class ArrayDequeTest {

	public static void main(String[] args) {
		ArrayDeque<Integer> c = new ArrayDeque<Integer>();
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
