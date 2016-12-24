package com.example.java.learn.reflect;

import java.lang.reflect.Method;

/** 
 * -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * 
 */
public class MyInterfaceReflect {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName(MyInterface.class.getName());
		Method method = clazz.getMethod("hi");
		System.out.println(method.getDeclaringClass());
		boolean b = method.getDeclaringClass() == Object.class;
		System.out.println(b);
	}

}
