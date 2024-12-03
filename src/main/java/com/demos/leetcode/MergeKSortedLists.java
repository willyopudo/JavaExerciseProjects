package com.demos.leetcode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        if (n == 1) return lists[0];
        int mid = n / 2;

        ListNode left = mergeTwoLists(lists[0], lists[mid]);
        ListNode[] newLists = new ListNode[mid];
        ListNode right = null;
        if(mid < n - 1)
            right = mergeTwoLists(lists[mid + 1], lists[n - 1]);
        return mergeKLists(new ListNode[]{left, right});
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
