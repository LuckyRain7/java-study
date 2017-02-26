package com.example.java.learn.lang;

public class IntOverflow {
	
	public static void main(String[] args) {
		final int i = Integer.MAX_VALUE;
		final int j = i + 1;
		System.out.printf("%d + 1 --> %d\n", i, j);
		
		final int m = Integer.MIN_VALUE;
		final int n = i - 1;
		System.out.printf("%d - 1 --> %d\n", m, n);
		
		Integer wrapI = Integer.MAX_VALUE;
		Integer wrapJ = wrapI + 1;
		System.out.printf("%d + 1 --> %d\n", wrapI, wrapJ);
		
		Integer wrapM = Integer.MAX_VALUE;
		Integer wrapN = wrapI + 1;
		System.out.printf("%d - 1 --> %d\n", wrapM, wrapN);
	}

}
