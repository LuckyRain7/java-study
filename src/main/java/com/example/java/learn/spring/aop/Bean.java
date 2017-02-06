package com.example.java.learn.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Bean {

//	@Autowired
	private Ref ref;

	@Deprecated
	private String testStr = "testStr";

	public Bean() {
		System.err.println("oops: Bean()");
	}

	public Ref getRef() {
		return ref;
	}

	public String getTestStr() {
		return testStr;
	}

	public void test() {
		System.out.println("test");
	}

}
