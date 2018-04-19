package com.zhouhe.thread;


public class Thread1 {
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();
		
		System.out.println(Thread.currentThread().getName()); //main
		System.out.println(Thread.currentThread().getThreadGroup().getName());//main
		
		
	    Thread[] list = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
	    
	    Thread.currentThread().getThreadGroup().enumerate(list);
	    
	    for (Thread t1 : list) {
	    	System.out.println(t1);
	    }
 	}
}
