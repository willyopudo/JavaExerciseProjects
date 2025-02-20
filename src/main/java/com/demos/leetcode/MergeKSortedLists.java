package com.demos.leetcode;
/*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.

    Example 1:
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6

    Example 2:
    Input: lists = []
    Output: []

    Example 3:
    Input: lists = [[]]
    Output: []


    Constraints:

    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }
    //Helper function to merge lists recursively using divide and conquer
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        //If we have only 1 item in the subdivided array, return head node of that item
        if (start == end) {
            return lists[start];
        }
        //If we have two items, merge the two lists
        if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        //Get new middle
        int mid = start + (end - start) / 2;
        //Recursively merge left side
        ListNode left = mergeKListsHelper(lists, start, mid);
        //Recursively merge right side
        ListNode right = mergeKListsHelper(lists, mid + 1, end);
        //Merge left and right
        return mergeTwoLists(left, right);
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
}
