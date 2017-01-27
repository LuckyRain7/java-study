package com.example.java.learn.util;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapTest {
	
	public static void main(String[] args) {
		HashMap<String, Integer> c = new HashMap<String, Integer>();
		c.put("1", 1);
		c.put("2", null);
		c.put("3", 3);
		System.out.println(c.size());
		for (Entry<String, Integer> e : c.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}
