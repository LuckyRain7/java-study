package com.example.java.learn.util.queue.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

	public static void main(String[] args) throws InterruptedException {
		final SynchronousQueue<Integer> c = new SynchronousQueue<Integer>();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				Integer i;
				try {
					i = c.take();
					System.out.println("received " + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		thread.start();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		c.addAll(list);
		// c.add(2);
		// c.add(3);
	}

}
