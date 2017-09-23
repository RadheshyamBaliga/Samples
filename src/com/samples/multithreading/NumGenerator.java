package com.samples.multithreading;

public class NumGenerator implements Runnable {
	
	private boolean isEvenNumGeneartor;
	private Printer printer;
	private int maxCount;
	
	public NumGenerator(Printer printer, int maxCount, boolean isEvenNumGeneartor) {
		this.printer = printer;
		this.maxCount = maxCount;
		this.isEvenNumGeneartor = isEvenNumGeneartor;
		
	}

	@Override
	public void run() {
		int number = isEvenNumGeneartor ? 0 : 1;
		while (number <= maxCount) {
			if (isEvenNumGeneartor) {
				printer.printEven(number);
			} else {
				printer.printOdd(number);
			}
			number += 2;
		}
		
	}

	

}
