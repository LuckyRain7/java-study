package com.example.java.learn.util.queue.threadsafe;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueTest {
	
	public static void main(String[] args) {
		LinkedTransferQueue<Integer> c = new LinkedTransferQueue<Integer>();
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
