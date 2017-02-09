package com.example.java.learn.util.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

public class UnparkAndParkDemo {

	private static class MyThread extends Thread {

		private final Thread thread;

		public MyThread(Thread thread) {
			super("MyThread");
			this.thread = thread;
		}

		@Override
		public void run() {
			System.out.println("Blocker Info: " + LockSupport.getBlocker(thread));
			LockSupport.unpark(thread);
			System.out.println("Blocker Info: " + LockSupport.getBlocker(thread));
	        System.out.println("after unpark");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread(Thread.currentThread());
		myThread.start();
		Thread.sleep(3000L);
        System.out.println("before park");
		LockSupport.park("ParkAndUnparkDemo");
		System.out.println("after park");
	}

}
