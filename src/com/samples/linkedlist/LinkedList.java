package com.samples.linkedlist;

public class LinkedList {
	
	private Node head;
	private Node tail;
	
	public LinkedList(Node node) {
		this.head = node;
		this.tail = node;
	}
	
	public void add(Node n) {
		this.tail.setNext(n);
		this.tail = n;
	}
	
	public Node head() {
		return head;
	}
	
	public void print() {
		Node n = head();
		while(n != null) {
			System.out.println(n.getName());
			n = n.getNext();
		}
	}

}
