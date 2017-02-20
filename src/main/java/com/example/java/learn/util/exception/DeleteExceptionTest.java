package com.example.java.learn.util.exception;

import java.util.ArrayList;

public class DeleteExceptionTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		for (String e : list) {
			if ("2".equals(e)) {
				list.remove(e);
			}
		}
	}

}
