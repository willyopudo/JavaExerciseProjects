package com.demos.collections;

import com.demos.collections.Node;

public class Main {
	public static void main(String[] args) {

//		SinglyLinkedList linkedList = new SinglyLinkedList(1);
//		linkedList.add(2);
//		linkedList.add(4);
//		linkedList.addAfter(2,3);
//
//		//linkedList.deleteFirst();
//
//		linkedList.showElements();

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		doublyLinkedList.addNode(1);
		doublyLinkedList.addNode(2);
		doublyLinkedList.addNode(3);
		doublyLinkedList.addNode(4);

		doublyLinkedList.showNodes();

	}

	/**
	 * Definition for singly-linked list.
	 * struct com.demos.collections.Node {
	 *     int val;
	 *     com.demos.collections.Node *next;
	 *     com.demos.collections.Node() : val(0), next(nullptr) {}
	 *     com.demos.collections.Node(int x) : val(x), next(nullptr) {}
	 *     com.demos.collections.Node(int x, com.demos.collections.Node *next) : val(x), next(next) {}
	 * };
	 */

		private static Node addTwoNumbers(Node l1, Node l2) {
			Node head1 = new Node(0);
			Node p = l1, s=l2, current = head1;

			int carry = 0;

			while(p != null || s != null){
				int x = (p != null) ? p.val : 0;
				int y = (s != null) ? s.val : 0;

				int sum = carry + x + y;
				carry = sum/10;

				current.next = new Node(sum % 10);
				current = current.next;

				if(p != null)
					p = p.next;
				if(s != null)
					s = s.next;

			}

			if(carry > 0){
				current.next = new Node(carry);

			}

			return head1.next;
		}

}



