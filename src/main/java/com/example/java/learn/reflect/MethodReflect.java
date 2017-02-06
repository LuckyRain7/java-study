package com.example.java.learn.reflect;

import java.lang.reflect.Method;
import java.util.Date;

public class MethodReflect {
	
	static class Child extends Book {
		private Date createdAt = new Date();

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		
		public void hi() {
			System.out.println("hi from child");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz = Class.forName(Child.class.getName());
		Method[] methods = clazz.getMethods();
		for (Method e : methods) {
			System.out.println(e.getDeclaringClass());
			System.out.println(e.getDeclaringClass() == Object.class);
			System.out.println(Object.class.equals(e.getDeclaringClass()));
			System.out.println(e.getModifiers() + " " + e.getReturnType().getName() + " " + e.getName() + "(...)");
		}
	}

}
