package com.zhouhe.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		while(true) {
			service.execute(new RunnableChildren());
		}
	}
}
