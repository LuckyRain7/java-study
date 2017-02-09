package com.example.java.learn.util.concurrent.locks;

public class WaitAndNotifyOkDemo {

	private static class MyThread extends Thread {
		@Override
		public void run() {
			synchronized (this) {
				System.out.println("before notify");
				notify();
				System.out.println("after notify");
			}
		}
	}

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		synchronized (myThread) {
			try {
				myThread.start();
				Thread.sleep(1000L);
				System.out.println("before wait");
				// 使用 wait/notify 实现同步时，必须先调用 wait，后调用 notify，
				// 如果先调用 notify，再调用 wait，将起不了作用
				myThread.wait();
				System.out.println("after wait");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
