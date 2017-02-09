package com.example.java.learn.util.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

public class ParkAndUnparkDemo {

	private static class MyThread extends Thread {

		private final Thread thread;

		public MyThread(Thread thread) {
			super("MyThread");
			this.thread = thread;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(15000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Blocker Info: " + LockSupport.getBlocker(thread));
			LockSupport.unpark(thread);
			try {
				// we have to sleep here so that 
				// LockSupport.getBlocker(thread)
				// returns null
				Thread.sleep(1L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Blocker Info: " + LockSupport.getBlocker(thread));
	        System.out.println("after unpark");
		}
	}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread(Thread.currentThread());
		myThread.start();
        System.out.println("before park");
		LockSupport.park("ParkAndUnparkDemo");
		System.out.println("after park");
	}

}
