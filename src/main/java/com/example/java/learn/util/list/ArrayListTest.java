package com.example.java.learn.util.list;

import java.util.ArrayList;

public class ArrayListTest {
	
	public static void main(String[] args) {
//		int i = 10;
//		int j = i + (i >> 1);
//		System.out.println("j: " + j);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(null);
		list.add(3);
		Integer dup = 4;
		list.add(dup);
		list.add(dup);
		for (Integer e : list) {
			System.out.println(e);
		}
		System.out.println(list.toArray(new Integer[list.size()]));
	}

}
