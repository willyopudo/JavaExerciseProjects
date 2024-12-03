package com.demos.leetcode;

import java.util.PriorityQueue;

/*
    Given the head of a linked list, return the list after sorting it in ascending order.

    Example 1:
    Input: head = [4,2,1,3]
    Output: [1,2,3,4]

    Example 2:
    Input: head = [-1,5,3,4,0]
    Output: [-1,0,3,4,5]

    Example 3:
    Input: head = []
    Output: []

    Constraints:
    The number of nodes in the list is in the range [0, 5 * 104].
    -105 <= Node.val <= 105

    Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */
public class SortList {
    /*Use merge Sort i.e divide and conquer algorithm
        Divide:
        Use a slow and fast pointer approach to find the middle of the linked list.
        Split the list into two halves.

        Conquer:
        Recursively sort both halves.

        Combine:
        Use a merge function to combine the sorted halves into one sorted list.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = getMiddle(head);
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeTwoLists(left, right);

        //Trivial solution using priority queue
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//        ListNode cur = head;
//        while(cur != null) {
//            pq.add(cur.val);
//            cur = cur.next;
//        }
//        head.val = pq.poll();
//        cur = head;
//        while(!pq.isEmpty()) {
//            cur.next.val = pq.poll();
//            cur = cur.next;
//        }
//        return head;
    }
    private ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);

        System.out.println(new SortList().sortList(head).val);
    }
}
