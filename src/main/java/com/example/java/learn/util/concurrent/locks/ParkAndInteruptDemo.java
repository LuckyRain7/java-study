package com.example.java.learn.util.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

public class ParkAndInteruptDemo {

	private static class MyThread extends Thread {

		private final Thread thread;

		public MyThread(Thread thread) {
			super("MyThread");
			this.thread = thread;
		}

		@Override
		public void run() {
			System.out.println("before interrupt");
			thread.interrupt();
			System.out.println("after interrupt");
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
