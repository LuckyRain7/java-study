package com.example.java.learn.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeanAdvisers {
	
	public BeanAdvisers() {
		System.err.println("oops: Adviser()");
	}
	
	@Pointcut("execution(* com.example.java.learn.spring.aop.Bean.test(..))")
	public void test() {
	}
	
	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
//	@After("test()")
	public void afterTest() {
		System.out.println("afterTest");
	}
	
//	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint pjp) {
		System.out.println("before1");
		Object o = null;
		try {
			o = pjp.proceed();
		} catch(Throwable t) {
			t.printStackTrace();
		}
		System.out.println("after1");
		return o;
	}
	
}
