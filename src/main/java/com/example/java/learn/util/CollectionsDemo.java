package com.example.java.learn.util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.Maps;

public class CollectionsDemo {
	
	public static void main(String[] args) {
		ConcurrentMap<Integer, Integer> map = Maps.newConcurrentMap();
		map.put(1, 1);
		Map<Integer, Integer> readOnlyMap = Collections.unmodifiableMap(map);
		
		// 1.
		System.out.println(readOnlyMap.get(1));
		
		// 2.
		map.putIfAbsent(2, 2);
		System.out.println(readOnlyMap.get(2));
		
		// 3.
		readOnlyMap.put(3, 3);
	}

}
