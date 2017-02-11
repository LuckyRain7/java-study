package com.example.java.learn.util.map;

import java.util.LinkedHashMap;

import com.example.java.learn.util.tool.Tool;

public class InsertionOrderedLinkedHashMapTest {
	
	private static final String NULL_VALUE = "null_value";
	private static final String APPLE = "apple";
	private static final String BANANA = "banana";

	public static void main(String[] args) {
		LinkedHashMap<String, String> c = new LinkedHashMap<String, String>(16, 0.75f, false);
		Tool.prepare(c);

		c.get(NULL_VALUE);
		
		// test null key
		c.put(null, null);
		Tool.print(c);

		// test null value
		c.put(NULL_VALUE, null);
		Tool.print(c);
		
		// test access order
		c.put(APPLE, APPLE);
		c.put(BANANA, BANANA);
		Tool.print(c);
		c.get(APPLE);
		Tool.print(c);
	}

}
