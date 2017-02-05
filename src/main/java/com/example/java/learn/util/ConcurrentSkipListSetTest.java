package com.example.java.learn.util;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetTest {
	
	public static void main(String[] args) {
		ConcurrentSkipListSet<String> c = new ConcurrentSkipListSet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
