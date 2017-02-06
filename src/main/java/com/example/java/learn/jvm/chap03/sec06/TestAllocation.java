package com.example.java.learn.jvm.chap03.sec06;

/**
 * 
 * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 
 * @author zhouwei
 *
 */
public class TestAllocation {
	
	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] alloc1;
		byte[] alloc2;
		byte[] alloc3;
		byte[] alloc4;
		
		alloc1 = new byte[2 * _1MB];
		alloc2 = new byte[2 * _1MB];
		alloc3 = new byte[2 * _1MB];
		alloc4 = new byte[4 * _1MB]; // 出现一次 Minor GC
	}
	
}
