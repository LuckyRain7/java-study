package com.example.java.learn.jvm.chap03.sec02;

/**
 * 
 * -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
 * 
 * @author zhouwei
 *
 */
public class ReferenceCountingGC {
	
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;
	
	private byte[] bigSize = new byte[2 * _1MB];
	
	public static void main(String[] args) throws InterruptedException {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		// 假设在这行发生 GC, objA 和 objB 是否能被回收？
		System.gc();
		Thread.sleep(3000);
	}

}
