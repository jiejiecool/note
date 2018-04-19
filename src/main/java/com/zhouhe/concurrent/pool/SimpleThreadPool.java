package com.zhouhe.concurrent.pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {
	private static int size;
	//线程池工作线程大小
	private static int DEFAULT_SIZE = 10;
	//任务队列大小
	private static int QUEUE_SIZE = 2000;
	private static int queueSize;
	private static LinkedList<Runnable> taskQueue = new LinkedList<>();
	private static List<WorkThread> workerList = new ArrayList<>();
	
	private static String Thread_GROUP = "Simple_Thread_Group";
	
	public SimpleThreadPool() {
		this(DEFAULT_SIZE,QUEUE_SIZE);
	}
	public SimpleThreadPool(int threadSize, int queueSize) {
		this.size = threadSize;
		this.queueSize = queueSize;
		init();
	}
	/**
	 * 初始化线程池,开启10个工作线程并加入list中方便管理
	 */
	private void init() {
		for (int i = 0;i < size;i++) {
			WorkThread thread = new WorkThread(new ThreadGroup(Thread_GROUP), "Thread__"+i);
			workerList.add(thread);
			thread.start();
		}
	}
	
	/**
	 * 提交任务的时候需要对taskqueue加锁，并且每提交一次任务都需要唤醒等待在taskqueue上的工作线程
	 * @param task
	 */
	public void submit(Runnable task) {
		synchronized (taskQueue) {
			taskQueue.addLast(task);
			taskQueue.notifyAll();
		}
	}
	
	public enum Thread_Status {
		FREE,BLOCK,RUNNING,DEAD
	}
	
	/**
	 * 定义工作线程
	 * @author jiejiecool
	 *
	 */
	public static class WorkThread extends Thread {
		private volatile Thread_Status status = Thread_Status.FREE;
		public WorkThread (ThreadGroup group, String name) {
			super(group, name);
		}
		
		@Override
		public void run() {
			//被打断的话重新运行的位置
			BLOCK_STAGING:
			while(status  != Thread_Status.DEAD) {
				Runnable runnable;
				synchronized (taskQueue) {
					//任务队列为空时，在任务队列上等待，直到被唤醒
					while(taskQueue.isEmpty()) {
						try {
							taskQueue.wait();
							status = Thread_Status.BLOCK;
						} catch (InterruptedException e) {
							break BLOCK_STAGING;
						}
					}
					runnable = taskQueue.removeFirst();
				}
				if (runnable != null) {
					status = Thread_Status.RUNNING;
					runnable.run();
					status = Thread_Status.FREE;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SimpleThreadPool pool = new SimpleThreadPool();
		System.out.println(workerList.size());
		for (int i=0;i<40;i++) {
			pool.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"start=========");
					System.out.println(Thread.currentThread().getName()+"finish=========");
				}
			});
		}
	}
	
}
