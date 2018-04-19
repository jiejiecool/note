package com.zhouhe.thread;

import org.junit.Test;

public class ThreadLocalTest {
	//@Test
	public void test() {
		final ThreadLocal<String> t = new ThreadLocal<String>();
		t.set("zhoujie");
		
		System.out.println(t.get());
		
		new Thread(new Runnable() {

			public void run() {
				System.out.println(t.get());
			}}).start();
	}
	
	@Test
	public void test1() {
		StringBuilder s = new StringBuilder();
		s.append("");
		s.append("");
		
		System.out.println(s.toString().equals(""));
	}
}
