package com.zhouhe.thread;

import java.io.IOException;
import java.net.Socket;

public class SocketHandler implements Runnable{
	
	private String info;

	private Socket socket;
	
	
	public SocketHandler(Socket socket, String info) {
		super();
		this.socket = socket;
		this.info = info;
	}


	public void run() {
		//此处不对socket做任何操作
		//只测试threadlocal的影响
		ThreadLocalHolder.setInfo(info);
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s  = ThreadLocalHolder.getInfo();
	}

}
