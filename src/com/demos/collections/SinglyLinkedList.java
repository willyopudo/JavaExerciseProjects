package com.demos.collections;

public class SinglyLinkedList {
	// First element
	Node head;
	// Last element
	Node tail;

	// headValue will be the first and last element
	//  when the Linked List is created
	SinglyLinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
	}
	// Add new node to the next reference
	// Add new node to the tail (end) of the Linked List
	void add(int value) {
		Node nodeValue = new Node(value);
		tail.next = nodeValue;
		tail = nodeValue;
	}
	void deleteFirst() {
		head = head.next;
	}
	//Insert node in the middle of the linked list
	void addAfter(int searchValue, int value) {
		var currentNode = head;

		while (currentNode != null) {
			if (currentNode.val == searchValue) {
				Node newNode = new Node(value);
				var nextNode = currentNode.next;
				currentNode.next = newNode;
				newNode.next = nextNode;
			}

			currentNode = currentNode.next;
		}
	}

	public void showElements() {
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
