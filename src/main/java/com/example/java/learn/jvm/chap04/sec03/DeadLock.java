package com.example.java.learn.jvm.chap04.sec03;

public class DeadLock {
	
	private static class SynAddRunnnable implements Runnable {
		private int a;
		private int b;
		
		public SynAddRunnnable(int a, int b) {
			this.a = a;
			this.b = b;
		}

		public void run() {
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddRunnnable(1, 2)).start();
			new Thread(new SynAddRunnnable(2, 1)).start();
		}
	}

}
