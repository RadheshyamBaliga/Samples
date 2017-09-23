package com.samples.multithreading.blockingqueues;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueueIntrinsic {
	
	private List<String> blockingQueue = new LinkedList<>();
	private int limit = 2;
	
	public BlockingQueueIntrinsic(int limit) {
		this.limit = limit;
	}
	
	public synchronized void enqueue(String s) throws InterruptedException {
		while(this.blockingQueue.size() == limit) {
			this.wait();
		}
		if (this.blockingQueue.size() == 0) {
			this.notifyAll();
		}
		this.blockingQueue.add(s);
		System.out.println("Enqueued " + s);
		
	}
	
	public synchronized String dequeue() throws InterruptedException {
		while(this.blockingQueue.size() == 0) {
			this.wait();
		}
		if (this.blockingQueue.size() == limit) {
			this.notifyAll();
		}
		
		String s = this.blockingQueue.remove(0);
		System.out.println("Dequeued " + s);
		return s;
		
	}
	
	public static void main(String[] args) {
		final BlockingQueueIntrinsic bq = new BlockingQueueIntrinsic(10);
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
