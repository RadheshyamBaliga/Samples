package com.samples.multithreading;

public class Printer {
	
	private boolean isEven;
	
	public synchronized void printEven(int number) {
		
		while (isEven == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("EVEN " + number);
		isEven = true;
		notify();
	}
	
	public synchronized void printOdd(int number) {
		while(isEven == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("ODD " + number);
		isEven = false;
		notify();
	}

}
