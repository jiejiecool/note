package com.zhouhe.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class RunnableExceptionProxy implements Runnable{
	private Runnable runnable;
	private CountDownLatch latch;
	private List<String> list;
	
	public void run() {
		try {
			runnable.run();
		}catch (Exception e) {
			list.add(e.getMessage());
		} finally {
			latch.countDown();
		}
		
	}
}
