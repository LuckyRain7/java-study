package com.example.java.learn.util.map;

import java.util.HashMap;

import com.example.java.learn.util.tool.Tool;

public class HashMapTest {
	
	public static void main(String[] args) {
		HashMap<String, String> c = new HashMap<String, String>();
		Tool.prepare(c);
		
		// test null value
		c.put("null_value", null);
		Tool.print(c);

		// test null key
		c.put(null, null);
		Tool.print(c);
	}

}
