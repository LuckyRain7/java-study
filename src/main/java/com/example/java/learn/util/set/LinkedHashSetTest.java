package com.example.java.learn.util.set;

import java.util.LinkedHashSet;

import com.example.java.learn.util.tool.Tool;

public class LinkedHashSetTest {
	
	public static void main(String[] args) {
		LinkedHashSet<String> c = new LinkedHashSet<String>();
		Tool.prepare(c);
		Tool.print(c);
		
		// test null
		c.add(null);
		Tool.print(c);
	}

}
