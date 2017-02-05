package com.example.java.learn.util;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapTest {
	
	public static void main(String[] args) {
		ConcurrentSkipListMap<String, String> c = new ConcurrentSkipListMap<String, String>();
		Tool.prepare(c);
		
		// test null value
		c.put("null_value", null);
		Tool.print(c);

		// test null key
		c.put(null, null);
		Tool.print(c);
	}

}
