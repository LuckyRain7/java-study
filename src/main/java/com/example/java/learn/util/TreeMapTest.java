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
		Tool.printMap(c.subMap("1", "3"));
		
		// tailMap()
		System.out.print("tailMap: ");
		Tool.printMap(c.tailMap("9"));

		// test null value
		c.put("null_value", null);
		Tool.printMap(c);

		// test null key
		c.put(null, null);
		Tool.printMap(c);
	}

}
