package com.samples.linkedlist;

public class CircularLinkedListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList l = new CircularLinkedList(new Node("0"));
		l.add(new Node("1"));
		l.add(new Node("2"));
		l.add(new Node("3"));
		l.add(new Node("4"));
		l.add(new Node("5"));
		l.add(new Node("6"));
		l.add(new Node("7"));
		l.add(new Node("8"));
		l.add(new Node("9"));
		
		l.print();
		
		l.delete();
		
		l.print();
		
		l.add(new Node("3*"), 3);
		
		l.print();
	}

}
