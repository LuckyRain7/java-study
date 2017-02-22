package com.example.java.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;

public class InvocationHandlerDemo implements InvocationHandler {

	private Object obj;

	public static Object newInstance(Class<?> clazz) {
		if (!clazz.isInterface()) {
			return null;
		}
		Class<?> someInterface = clazz;
		return Proxy.newProxyInstance(someInterface.getClassLoader(), new Class[]{someInterface},
				new InvocationHandlerDemo(someInterface));
	}

	public InvocationHandlerDemo(Object object) {
		this.obj = object;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("----- foo -----");
		System.out.println(proxy.getClass());
		//Object ret = method.invoke(this.obj, args);
		System.out.println("----- bar -----");
		return obj;
	}
	
	public static void main(String[] args) {
		byte[] src = "你好".getBytes(StandardCharsets.UTF_8);
		String dest = new String(src, StandardCharsets.UTF_8);
		System.out.println(dest);
		Bird proxy = (Bird) newInstance(Bird.class);
		proxy.fly();
		System.out.println("real class: " + proxy.getClass());
		System.out.println(proxy instanceof Bird);
		System.out.println(Bird.class.isAssignableFrom(proxy.getClass()));
	}

}
