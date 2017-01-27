package com.example.java.learn.reflect;

import java.util.HashSet;
import java.util.Set;

public class ClassDemo {

	private interface Parent {
	}

	private class ParentImpl implements Parent {
	}

	private interface Child {
	}

	private class ChildImpl extends ParentImpl implements Child, Parent {
	}

	private static void getAllInterfaces(Class<?> clazz, Set<Class<?>> found) {
		for (Class<?> e : clazz.getInterfaces()) {
			found.add(e);
		}
		Class<?> parent = clazz.getSuperclass();
		if (parent == null || found.contains(parent) || (parent.equals(Object.class))) {
			return;
		}
		System.out.println("parent class found: " + parent);
		getAllInterfaces(parent, found);
	}
	
	static Set<Class<?>> getAllInterfaces(Class<?> clazz) {
		Set<Class<?>> ret = new HashSet<Class<?>>();
		getAllInterfaces(clazz, ret);
		return ret;
	}

	public static void main(String[] args) {
		Set<Class<?>> ifs = getAllInterfaces(ChildImpl.class);
		for (Class<?> clazz : ifs) {
			System.out.println(clazz.getName());
		}
	}

}
