package com.example.java.learn.jvm.chap07.sec02;

public class SubClass extends SuperClass {
	
	public static int value = 123;

	static {
		System.out.println("SubClass init!");
	}
	
}
