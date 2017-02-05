package com.example.java.learn.util;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {
	
	public static void main(String[] args) {
		CopyOnWriteArraySet<String> c = new CopyOnWriteArraySet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test duplications
		String dup = "dup";
		c.add(dup);
		c.add(dup);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
