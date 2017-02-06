package com.example.java.learn.jvm.chap03.sec06;

/**
 * 
 * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * 
 * @author zhouwei
 *
 */
public class TestPretenureSizeThreshold {
	
	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] alloc1 = new byte[4 * _1MB]; 
	}
	
}
