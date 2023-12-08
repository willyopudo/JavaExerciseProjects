package com.demos.collections;

public class DoublyLinkedList {
	Node head = null;
	Node tail = null;

	public void addNode(int element) {
		Node newNode = new Node(element);

		if (head == null) {
			head = newNode;
			tail = newNode;
			head.previous = null;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		newNode.next = null;
	}

	public void showNodes() {
		Node currentNode = head;
		if(head == null) {
			return;
		}
		while(currentNode != null) {
			System.out.println(currentNode.val);
			currentNode = currentNode.next;
		}
	}

}
