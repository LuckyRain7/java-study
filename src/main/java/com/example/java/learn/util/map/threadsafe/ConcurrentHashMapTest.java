package com.example.java.learn.util.map.threadsafe;

import java.util.concurrent.ConcurrentHashMap;

import com.example.java.learn.util.tool.Tool;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> c = new ConcurrentHashMap<String, String>();
		Tool.prepare(c);
		
		// test null value
		c.put("null_value", null);
		Tool.print(c);

		// test null key
		c.put(null, null);
		Tool.print(c);
	}

}
