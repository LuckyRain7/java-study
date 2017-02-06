package com.example.java.learn.util.list.threadsafe;

import java.util.concurrent.CopyOnWriteArrayList;

import com.example.java.learn.util.tool.Tool;

public class CopyOnWriteArrayListTest {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> c = new CopyOnWriteArrayList<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
