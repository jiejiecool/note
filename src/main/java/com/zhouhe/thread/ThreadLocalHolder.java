package com.zhouhe.thread;

public class ThreadLocalHolder {
	
	
	private static ThreadLocal<String> logInfo = new ThreadLocal<String>();
	
	public static void setInfo(String info) {
		logInfo.set(info);
	} 
	
	public static String getInfo() {
		if (logInfo.get() == null) {
			return "";
		} else {
			return logInfo.get();
		}
	}
	
	public static void remove() {
		logInfo.remove();
	}
	
}
