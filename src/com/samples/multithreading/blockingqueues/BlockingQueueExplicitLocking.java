package com.samples.multithreading.blockingqueues;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueExplicitLocking {
	
	private List<String> blockingQueue = new LinkedList<>();
	private int limit;
	private Lock lock;
	private Condition isFullCon;
	private Condition isEmptyCon;
	
	public BlockingQueueExplicitLocking(int limit) {
		this.limit = limit;
		lock = new ReentrantLock();
		isFullCon = lock.newCondition();
		isEmptyCon = lock.newCondition();
	}
	
	public void enqueue(String s) throws InterruptedException {
		try {
			lock.tryLock();
			while(this.blockingQueue.size() == limit) {
				isFullCon.await();
			}
			if (this.blockingQueue.size() == 0) {
				isEmptyCon.signalAll();
			}
			blockingQueue.add(s);
			System.out.println("Enqueued " + s);
		} finally {
			lock.unlock();
		}
	}
	
	public String dequeue() throws InterruptedException {
		try {
			lock.tryLock();
			while(this.blockingQueue.size() == 0) {
				isEmptyCon.await();
			}
			if (this.blockingQueue.size() == limit) {
				isFullCon.signalAll();
			}
			String s = blockingQueue.remove(0);
			System.out.println("Dequeued " + s);
			return s;
		} finally {
			lock.unlock();
		}
	}
	
	
	
	public static void main(String[] args) {
		final BlockingQueueExplicitLocking bq = new BlockingQueueExplicitLocking(10);
		Thread t1 = new Thread() {
			public void run() {
				for(int i=0; i< 10; i++) {
					try {
						bq.enqueue("" + i);
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				try {
					while (bq.dequeue() != null) {
						//System.out.println();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
