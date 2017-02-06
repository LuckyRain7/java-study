package com.example.java.learn.util.map;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class EnumMapTest {
	
	static enum Color {
		
		BLUE (1),
		GREEN (2),
		RED (3);
		
		final int code;
		
		Color(int code) {
			this.code = code;
		}
		
	}
	
	public static void main(String[] args) {
		EnumMap<Color, String> c = new EnumMap<Color, String>(Color.class);
		
		// test null value
		c.put(Color.RED, Color.RED.toString());
		c.put(Color.GREEN, Color.GREEN.toString());
		c.put(Color.BLUE, null);
		Iterator<Entry<Color, String>> it = c.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Color, String> entry = it.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

		// test null key
		c.put(null, null);
	}

}
