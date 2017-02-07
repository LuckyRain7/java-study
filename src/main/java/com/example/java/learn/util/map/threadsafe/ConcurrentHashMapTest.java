package com.example.java.learn.util.map.threadsafe;

import java.util.concurrent.ConcurrentHashMap;

import com.example.java.learn.util.tool.Tool;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) throws InterruptedException {
		final ConcurrentHashMap<String, String> c = new ConcurrentHashMap<String, String>();
		Tool.prepare(c);
		
		// test iterator thread-safety
		System.out.println("will test concurrent read and write...");
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (String key : c.keySet()) {
					c.remove(key);
					try {
						Thread.sleep(100L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		for (int i = 0; i < 10; ++i) {
			Tool.print(c);
			Thread.sleep(150L);
		}
		
		// test null value
		c.put("null_value", null);
		Tool.print(c);
		
		// test null key
		c.put(null, null);
		Tool.print(c);
		
	}

}
