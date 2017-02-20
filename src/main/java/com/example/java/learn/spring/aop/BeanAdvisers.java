package com.example.java.learn.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
	public void beforeTest_1() {
		System.out.println("before_1 OK");
	}
	
	@Before("test()")
	public void beforeTest_2() {
		System.out.println("before_2 OK");
	}
	
	@After("test()")
	public void afterTest_2() {
		System.out.println("after_2 OK");
	}
	
	@After("test()")
	public void afterTest_1() {
		System.out.println("after_1 OK");
	}
	
	@After("test()")
	public void afterReturningTest_1() {
		System.out.println("afterReturning_1 OK");
	}
	
	@After("test()")
	public void afterReturningTest_2() {
		System.out.println("afterReturning_2 OK");
	}
	
	@Around("test()")
	public Object aroundTest_2(ProceedingJoinPoint pjp) {
		System.out.println("around_2 start");
		Object o = null;
		try {
			o = pjp.proceed();
		} catch(Throwable t) {
			t.printStackTrace();
		}
		System.out.println("around_2 end");
		return o;
	}
	
	@Around("test()")
	public Object aroundTest_1(ProceedingJoinPoint pjp) {
		System.out.println("around_1 start");
		Object o = null;
		try {
			o = pjp.proceed();
		} catch(Throwable t) {
			t.printStackTrace();
		}
		System.out.println("around_1 end");
		return o;
	}
	
}
