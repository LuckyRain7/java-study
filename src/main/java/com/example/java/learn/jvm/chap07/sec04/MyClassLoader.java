package com.example.java.learn.jvm.chap07.sec04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MyClassLoader extends ClassLoader {

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> ret = findLoadedClass(name);
		if (ret != null) {
			System.out.println(name + " has been loaded");
			return ret;
		}
		
		InputStream is = null;
		try {
			String fileName = name.replaceAll("\\.", "/");
			String path = "/Users/zhouwei/Desktop/zw/tmp/" + fileName + ".class";
			System.out.println("path: " + path);
			is = new FileInputStream(path);
			byte[] b = new byte[is.available()];
			is.read(b);
			return defineClass(name, b, 0, b.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(name);
		}
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		MyClassLoader myLoader = new MyClassLoader();
		Object obj1 = myLoader.loadClass("com.example.java.learn.jvm.chap07.sec04.A").newInstance();
		System.out.println(obj1);
		Object obj2 = myLoader.loadClass("com.example.java.learn.jvm.chap07.sec04.A").newInstance();
		System.out.println(obj2);
	}
	
	void printClassLoaders() {
		ClassLoader loader = getClass().getClassLoader(); // 获得加载ClassLoaderTest.class这个类的类加载器
		while (loader != null) {
			System.out.println(loader);
			loader = loader.getParent(); // 获得父类加载器的引用
		}
		System.out.println(loader);
		System.out.println();
		System.out.println("thread context class loader: " + Thread.currentThread().getContextClassLoader());

		System.out.println("CLASSPATH: " + System.getProperty("CLASSPATH"));
		System.out.println();
		System.out.println("sun.boot.class.path: " + System.getProperty("sun.boot.class.path"));
		System.out.println();
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i].toExternalForm());
		}
		System.out.println();
	}


}
