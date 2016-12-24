package com.example.java.learn.proxy;

public class Alice {

	public static void main(String[] args) {
		Child child = new Child();
		Parent p = (Parent) child;
		p.callHi();
	}
	
}

class Parent {
	
	public void hi() {
		System.out.println("parent");
	}
	
	public void callHi() {
		hi();
	}
}

class Child extends Parent {
	
	@Override
	public void hi() {
		System.out.println("child");
	}
}
