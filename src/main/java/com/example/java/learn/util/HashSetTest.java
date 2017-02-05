package com.example.java.learn.util;

import java.util.HashSet;

public class HashSetTest {
	
	public static void main(String[] args) {
		HashSet<String> c = new HashSet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
