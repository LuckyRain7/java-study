package com.example.java.learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;

public class EagleProxy implements InvocationHandler {

	private Object obj;

	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				new EagleProxy(obj));
	}

	public EagleProxy(Object object) {
		this.obj = object;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("----- foo -----");
		Object ret = method.invoke(this.obj, args);
		System.out.println("----- bar -----");
		return ret;
	}
	
	public static void main(String[] args) {
		Eagle eagle = new Eagle();
		byte[] src = "你好".getBytes(StandardCharsets.UTF_8);
		String dest = new String(src, StandardCharsets.UTF_8);
		System.out.println(dest);
		Bird proxy = (Bird) newInstance(eagle);
		proxy.fly();
	}

}
