package com.example.java.learn.jvm.chap07.sec02;

public class ConstClass {

	static {
		System.out.println("ConstClass init!");
	}
	
	public static final String HELLOWORLD = "Hello world";
	
}
