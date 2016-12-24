package com.example.java.learn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;

public class Book {
	
	public String publicString = "public";

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		Object obj = Class.forName("com.example.java.learn.reflect.Book").newInstance();
		Book book = (Book) obj;
		Method idSetMethod = Book.class.getMethod("setId", Long.class);
		idSetMethod.invoke(book, 1L);
		Field[] fields = book.getClass().getFields();
		for (Field f : fields) {
			System.out.println(f.getName());
			System.out.println(f.get(book));
		}
//		System.out.println(book);
	}

}
