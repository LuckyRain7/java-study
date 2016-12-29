package com.example.java.learn.jvm.chap02.sec04;

import java.lang.reflect.Field;
import sun.misc.Unsafe;  

/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * @author zhouwei
 *
 */
public class DirectMemmoryOOM {
	
	private static final int _1MB = 1024 * 1024;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_1MB);
		}
	}

}
