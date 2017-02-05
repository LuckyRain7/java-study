package com.example.java.learn.util.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	
	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		list.add(1);
		list.add(null);
		list.add(3);
		Integer dup = 4;
		list.add(dup);
		list.add(dup);
		for (Integer e : list) {
			System.out.println(e);
		}
	}

}
