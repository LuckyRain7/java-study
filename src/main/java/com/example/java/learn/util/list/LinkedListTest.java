package com.example.java.learn.util.list;

import java.util.LinkedList;

public class LinkedListTest {
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(null);
		list.add(3);
		for (Integer e : list) {
			System.out.println(e);
		}
	}

}
