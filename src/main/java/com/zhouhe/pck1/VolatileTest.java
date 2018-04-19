package com.zhouhe.pck1;

import org.junit.Test;

public class VolatileTest {
	private int a = 1;
	@Test
	public void test() throws InterruptedException {
		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				try {
					a++;
					Thread.sleep(1000);
					a++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		System.out.println(a);
		Thread.sleep(1000);
		System.out.println(a);
	}
}
