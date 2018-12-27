package com.zhouhe.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class myblockingqueue {
	private ReentrantLock lock = new ReentrantLock();
	
	//写条件
	private Condition writeCondition = lock.newCondition();
	//读条件
	private Condition readCondition = lock.newCondition();
	
	private int[] arr = new int[100];
	//写位置 读位置 数据总数
	private int writeptr,readptr,count;
	
	private void put(int i) throws InterruptedException {
		lock.lock();
		try {
			while(count == arr.length) {
				writeCondition.await();
			}


			///
			arr[writeptr] = i;
			
			if (++writeptr == arr.length) {
				writeptr = 0;
			}
			++count;
			
			//写数据完成后，唤醒读线程
			readCondition.signal();
		}finally {
			lock.unlock();
		}
	}
	
	
	private int take() throws InterruptedException {
		lock.lock();
		try {
			while (count == arr.length) {
				readCondition.await();
			}
		}finally {
			lock.unlock();
		}
		return 0;
	}
}
