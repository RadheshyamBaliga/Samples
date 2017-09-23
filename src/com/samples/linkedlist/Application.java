package com.samples.linkedlist;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList(new Node("0"));
		l.add(new Node("1"));
		l.add(new Node("2"));
		l.add(new Node("3"));
		l.add(new Node("4"));
		l.add(new Node("5"));
		l.add(new Node("6"));
		l.add(new Node("7"));
		l.add(new Node("8"));
		l.add(new Node("9"));
		//l.print();
		/**
		 * find the middle element of linked list
		 */
		int counter = 0, middleCounter = 0;
		Node middle = l.head();
		Node n = l.head();
		while(n != null) {
			counter++;
			if (counter%2 ==0){
				middleCounter++;
				middle = middle.getNext();
				
			}
			n = n.getNext();
		}
		
		System.out.println(middleCounter + " " + middle.getName());

	}

}
