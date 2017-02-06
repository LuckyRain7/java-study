package com.example.java.learn.util.list;

import java.util.ArrayList;

public class ArrayListTest {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(null);
		list.add(3);
		for (Integer e : list) {
			System.out.println(e);
		}
		System.out.println(list.toArray(new Integer[list.size()]));
	}

}
