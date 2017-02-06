package com.example.java.learn.util.map;

import java.util.LinkedHashMap;

import com.example.java.learn.util.tool.Tool;

public class LinkedHashMapTest {
	
	public static void main(String[] args) {
		LinkedHashMap<String, String> c = new LinkedHashMap<String, String>();
		Tool.prepare(c);

		// test null value
		c.put("null_value", null);
		Tool.print(c);

		// test null key
		c.put(null, null);
		Tool.print(c);
	}

}
