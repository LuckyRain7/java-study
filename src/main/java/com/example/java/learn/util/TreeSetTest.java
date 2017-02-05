package com.example.java.learn.util;

import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args) {
		TreeSet<String> c = new TreeSet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
