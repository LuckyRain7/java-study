package com.example.java.learn.util.set.threadsafe;

import java.util.concurrent.ConcurrentSkipListSet;

import com.example.java.learn.util.tool.Tool;

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
