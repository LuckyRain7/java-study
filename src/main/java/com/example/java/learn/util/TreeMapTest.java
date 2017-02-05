package com.example.java.learn.util;

import java.util.TreeMap;

public class TreeMapTest {
	
	public static void main(String[] args) {
		TreeMap<String, String> c = new TreeMap<String, String>();
		Tool.prepare(c);

		// test null value
		c.put("null_value", null);
		Tool.printMap(c);

		// test null key
		c.put(null, null);
		Tool.printMap(c);
	}

}
