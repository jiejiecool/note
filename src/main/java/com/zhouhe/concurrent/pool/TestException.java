package com.zhouhe.concurrent.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestException {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<String> future = service.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "1";
				//throw new RuntimeException("抛出异常");
			}
		});
		
		System.out.println("---------------------");
		Thread.sleep(2000);
		try {
			System.out.println(future.get());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("================");
		//service.shutdown();
	}
	
	
}
