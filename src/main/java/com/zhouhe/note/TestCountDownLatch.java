package com.zhouhe.note;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
	public static void main(String[] args) {
		final CountDownLatch down = new CountDownLatch(1);
		
		Executors.newFixedThreadPool(2).execute(new Runnable() {

			public void run() {
				try {
					Thread.sleep(10000);
					down.countDown();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		
		System.out.println("11111111111111111111111");
		
		try {
			down.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("222222222222222222222222");
		
	}
}
