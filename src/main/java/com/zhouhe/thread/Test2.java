package com.zhouhe.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test2 {
	public static Integer say() throws Exception{
		//throw new RuntimeException("11111");
		return 1;
	}
	
	
	public static void main(String[] args) {
		Future<Integer> fu = Executors.newFixedThreadPool(1).submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				
				return say();
			}
		});
		try {
			System.out.println(fu.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
