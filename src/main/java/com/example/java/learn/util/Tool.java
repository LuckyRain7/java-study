package com.example.java.learn.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class Tool {

	private Tool() {
	}

	public static void prepare(Map<String, String> map) {
		for (int i = 9; i > 0; --i) {
			String key = i + "_" + UUID.randomUUID().toString().toLowerCase();
			String value = "" + i;
			map.put(key, value);
		}
	}

	public static <K, V> void printMap(Map<K, V> map) {
		Iterator<Entry<K, V>> it = map.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		boolean empty = map.isEmpty();
		while (it.hasNext()) {
			Entry<K, V> entry = it.next();
			sb.append("<");
			sb.append(entry.getKey());
			sb.append(",");
			sb.append(entry.getValue());
			sb.append(">");
			sb.append(", ");
		}
		if (!empty) {
			sb.delete(sb.length() - 2, sb.length());
		}
		System.out.println(sb.toString());
	}

}
