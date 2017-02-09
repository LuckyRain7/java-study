package com.example.java.learn.util.map;

import java.util.IdentityHashMap;

import com.example.java.learn.util.tool.Tool;

public class IdentityHashMapTest {
	
	public static void main(String[] args) {
		IdentityHashMap<String, String> c = new IdentityHashMap<String, String>();
		Tool.prepare(c);
		
		// test null value
		c.put("null_value", null);
		Tool.print(c);

		// test null key
		c.put(null, null);
		Tool.print(c);
	}

}
