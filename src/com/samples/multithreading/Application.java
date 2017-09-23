package com.samples.multithreading;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxCount = 10;
		Printer p = new Printer();
		NumGenerator evenNumGenerator = new NumGenerator(p, maxCount, true);
		NumGenerator oddNumGenerator = new NumGenerator(p, maxCount, false);
		Thread evenNumGenThread = new Thread(evenNumGenerator);
		Thread oddNumGeneratorThread = new Thread(oddNumGenerator);
		evenNumGenThread.start();
		oddNumGeneratorThread.start();

	}

}
