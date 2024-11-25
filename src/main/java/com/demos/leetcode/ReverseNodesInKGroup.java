package com.demos.leetcode;

import java.util.HashMap;
import java.util.Map;
/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:

images/leetcode/reversenodes-in-k-group-0.png
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

images/leetcode/reverse-nodes-in-k-group-1.png
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 */

public class ReverseNodesInKGroup {

    //Solution 1 : Load the linked list to a hashmap and iterate the map as we swap nodes
    //Time complexity - O(N)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(index++, head);
            head = head.next;
        }
        //compute how many cycles we should go based on size of linked list and k value
        int iterationCount = map.size()/k;

        for(int count = 0; count < iterationCount; count++) {
            //using 2 pointer
            int left = count * k, right = left+k-1;
            while (left < right) {
                //Put node at left index in temp
                ListNode temp = map.get(left);
                //Swap the nodes at left and right indexes
                map.put(left, map.get(right));
                map.put(right, temp);

                //Update next node for current node at left index
                map.get(left).next = map.get(left+1);

                //Update next node to the left of the node at our left index
                if(left - 1 >= 0) map.get(left -1).next = map.get(left);

                //Update next node for current node at right index , if node at right index is the last, update next to null
                if(right  + 1 < map.size()) map.get(right).next = map.get(right+1);
                else map.get(right).next = null;
                map.get(right - 1).next = map.get(right); //Update next node for node to the left of the node at our right index

                //Increment left pointer and decrement right pointer
                left++;
                right--;
            }

        }
        //return first node in the hashmap
        return map.get(0);
    }

    /*TODO
    Come up with a solution which does not need to store the nodes in a hashmap
    */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = new ReverseNodesInKGroup().reverseKGroup(head, 3);
        while (newHead != null) {
            System.out.print(newHead.val + ", ");
            newHead = newHead.next;
        }
    }
}
