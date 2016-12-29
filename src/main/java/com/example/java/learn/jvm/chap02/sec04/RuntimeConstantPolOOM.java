package com.example.java.learn.jvm.chap02.sec04;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxMetaspaceSize=10M
 * 
 * @author zhouwei
 *
 */
public class RuntimeConstantPolOOM {

	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		
		// 使用 List 保持常量池饮用，避免 Full GC 回收常量池行为
//		List<String> list= new ArrayList<String>();
//		// 10 MB 的 PermSize 在 integer 范围内足够产生 OOM 了
//		int i = 0;
//		while (true) {
//			String str = String.valueOf(i++).intern();
//			list.add(str);
//			System.out.println(str);
//		}
	}
	
}
