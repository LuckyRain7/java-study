package com.example.java.learn.util.set.threadsafe;

import java.util.concurrent.CopyOnWriteArraySet;

import com.example.java.learn.util.tool.Tool;

public class CopyOnWriteArraySetTest {
	
	public static void main(String[] args) {
		CopyOnWriteArraySet<String> c = new CopyOnWriteArraySet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
