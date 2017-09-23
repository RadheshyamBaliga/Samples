package com.samples.linkedlist;

public class CircularLinkedList {

	private Node head;
	private Node tail;
	
	public CircularLinkedList(Node node) {
		this.head = node;
		this.tail = node;
	}
	
	public void add(Node n) {
		this.tail.setNext(n);
		this.tail = n;
		this.tail.setNext(this.head);
	}
	
	public void add(Node n, int pos) {
		int tempPos = 1;
		Node temp = this.head;
		while(temp.getNext() != null) {
			tempPos++;
			if (tempPos == pos) {
				Node current = temp;
				Node tempNext = temp.getNext();
				n.setNext(tempNext);
				current.setNext(n);
				break;
			}
			temp = temp.getNext();
		}
		
	}
	
	public void delete() {
		this.head = this.head.getNext();
		this.tail.setNext(this.head);
	}
	
	public void print() {
		Node n = this.head;
		String name = n.getName();
		while(n != null) {
			System.out.println(n.getName());
			n = n.getNext();
			if (name.equals(n.getName())) {
				System.out.println("reached end");
				break;
			}
		}
	}



}
