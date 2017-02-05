package com.example.java.learn.util;

import java.util.TreeMap;

public class TreeMapTest {
	
	public static void main(String[] args) {
		TreeMap<String, String> c = new TreeMap<String, String>();
		Tool.prepare(c);
		
		// firstKey()
		System.out.print("firstKey: ");
		System.out.println(c.firstKey());
		
		// lastKey()
		System.out.print("lastKey: ");
		System.out.println(c.lastKey());
		
		// subMap()
		System.out.print("subMap: ");
		Tool.print(c.subMap("1", "3"));
		
		// tailMap()
		System.out.print("tailMap: ");
		Tool.print(c.tailMap("9"));

		// test null value
		c.put("null_value", null);
		Tool.print(c);

		// test null key
		c.put(null, null);
		Tool.print(c);
	}

}
