package com.example.java.learn.util;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	
	public static void main(String[] args) {
		LinkedHashSet<String> c = new LinkedHashSet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
