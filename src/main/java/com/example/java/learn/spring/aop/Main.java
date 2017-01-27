package com.example.java.learn.spring.aop;

import java.lang.annotation.Annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Annotation[] annotations = null;
		annotations = Bean.class.getAnnotations();
		for (Annotation e : annotations) {
			System.out.println(e);
		}
		annotations = Bean.class.getDeclaredField("testStr").getAnnotations();
		for (Annotation e : annotations) {
			System.out.println(e);
		}
		System.out.println("-------------------------------------------------");
		
		ConfigurableApplicationContext cac = SpringApplication.run(Main.class, args);
		Bean bean = cac.getBean(Bean.class);
		bean.test();
		System.out.println(bean.getClass());
		cac.close();
	}

}
