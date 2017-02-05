package com.example.java.learn.util;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
	
	public static void main(String[] args) {
		LinkedHashMap<String, String> c = new LinkedHashMap<String, String>();
		Tool.prepare(c);

		// test null value
		c.put("null_value", null);
		Tool.printMap(c);

		// test null key
		c.put(null, null);
		Tool.printMap(c);
	}

}
