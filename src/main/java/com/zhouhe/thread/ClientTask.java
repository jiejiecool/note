package com.zhouhe.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTask implements Runnable{

	public void run() {
		Socket socket = null;
		OutputStream out  = null;
		try {
			socket = new Socket("127.0.0.1", 8544);
			out = socket.getOutputStream();
			out.write((byte)'H');
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}