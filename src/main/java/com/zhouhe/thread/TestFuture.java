package com.zhouhe.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
	
		
		Future<String> future = Executors.newSingleThreadScheduledExecutor().submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.currentThread().sleep(8000);
				return "1";
			}
			
		});
		
		Thread.currentThread().sleep(10000);
		System.out.println("2");
		System.out.println(future.get());
		
	}
}
