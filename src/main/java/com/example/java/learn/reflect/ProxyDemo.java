package com.example.java.learn.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {

	private static interface MyInterface {
		void hi();
	}

	private static class MyInterfaceImpl implements MyInterface {

		@Override
		public void hi() {
			System.out.println("hi");
		}

	}

	private static class MyInvocationHandler implements InvocationHandler {

		private final Object target;

		public MyInvocationHandler(Object target) {
			this.target = target;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("--- before real invoking ---");
			Object ret = method.invoke(target, args);
			System.out.println("===  after real invoking ===");
			return ret;
		}

		public Object getProxy() {
			return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
					target.getClass().getInterfaces(), this);
		}

	}

	public static void main(String[] args) {
		MyInterface target = new MyInterfaceImpl();
		MyInvocationHandler myIh = new MyInvocationHandler(target);
		MyInterface proxy = (MyInterface) myIh.getProxy();
		proxy.hi();
	}

}
