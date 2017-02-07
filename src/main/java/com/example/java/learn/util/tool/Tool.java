package com.example.java.learn.util.tool;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

public class Tool {

	private Tool() {
	}
	
	public static void prepare(Collection<String> set) {
		for (int i = 9; i > 0; --i) {
			String key = i + "_" + UUID.randomUUID().toString().toLowerCase();
			set.add(key);
		}
	}

	public static void prepare(Map<String, String> map) {
		for (int i = 9; i > 0; --i) {
			String key = i + "_" + UUID.randomUUID().toString().toLowerCase();
			String value = "" + i;
			map.put(key, value);
		}
	}
	
	public static void print(Collection<String> set) {
		Iterator<String> it = set.iterator();
		StringBuilder sb = new StringBuilder();
		boolean empty = set.isEmpty();
		while (it.hasNext()) {
			String value = it.next();
			if (value == null) {
				sb.append("null");
			} else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}
			sb.append(", ");
		}
		if (!empty) {
			sb.delete(sb.length() - 2, sb.length());
		}
		System.out.println(sb.toString());
		System.out.println();
	}

	public static void print(Map<String, String> map) {
		final StringBuilder sb = new StringBuilder();
		map.forEach(new BiConsumer<String, String>() {
			@Override
			public void accept(String key, String value) {
				sb.append("<");
				if (key == null) {
					sb.append("null");
				} else {
					sb.append("'");
					sb.append(key);
					sb.append("'");
				}
				sb.append(",");
				if (value == null) {
					sb.append("null");
				} else {
					sb.append("'");
					sb.append(value);
					sb.append("'");
				}
				sb.append("> ");
			}
		});
		System.out.println(sb.toString());
		System.out.println();
	}

}
