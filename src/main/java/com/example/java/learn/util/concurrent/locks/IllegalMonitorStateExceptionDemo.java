package com.example.java.learn.util.concurrent.locks;

public class IllegalMonitorStateExceptionDemo {
	
	private static final long SLEEP_MILLIS = 15000L;

	private static class MyThread extends Thread {
		
		public MyThread() {
			super("my_thread");
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(SLEEP_MILLIS - 5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("before notify");
			notify();
			System.out.println("after notify");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		System.out.println("before wait");
		myThread.wait();
		Thread.sleep(SLEEP_MILLIS);
		System.out.println("after wait");
	}

}
