package com.zhouhe.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketClient {
	
	private static int ThreadNUM = 20000;
	
	private static int port = 8544;
	public static void main(String[] args) {
		//CyclicBarrier barrier = new CyclicBarrier(ThreadNUM);
		
		
		ExecutorService service = Executors.newFixedThreadPool(ThreadNUM);
		while(true) {
			Thread thread = new Thread(new ClientTask());
			thread.start();
		}
		
	}
	

}
