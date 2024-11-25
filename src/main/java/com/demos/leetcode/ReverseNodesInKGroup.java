package com.demos.leetcode;

import java.util.HashMap;
import java.util.List;
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

    /*
    Solution 2 : Reverse node pointers for K group if current node count is divisible by k (1ms)
    */
    public ListNode reverseKGroupV2(ListNode head, int k) {
        //validate input linked list
        if (head == null || head.next == null || k == 1) return head;

        //Initialize variables
        ListNode current = head, prev = head, next = head.next, ans = head, tail = head;
        //Counter for number of nodes
        int count = 1;

        //Loop through all nodes
        while (current != null) {
            //Save current node in a variable for later use
            ListNode thisNode = current;

            //Update current node for our while loop
            current = current.next;

            //Check if the counter is divisible by k
            if(count % k == 0){
                //For the first K group override next of the head node to current node in our while loop i.e thisNode.next
                if(count == k) head.next = current;
                //Else update variables used to process the  next K group
                else{
                    tail.next = thisNode;
                    prev = next;
                    next = next.next;

                }
                //Loop k-1 times
                for(int i = 1; i < k; i++){
                    //Save next.next to a temp variable because we want to override it
                    ListNode temp = next != null ? next.next : null;
                    //Override next.next with previous node - here is where we do swapping
                    if(next != null)  next.next = prev;

                    //If we are processing 2nd..nth K group, update value of tail accordingly
                    if(count > k && i == 1) tail = prev;
                    //Assign new value to tail. It is the temp node above which was next of next
                    tail.next = temp;

                    //Update variables for next iteration
                    prev = next;
                    next = temp;

                    //Let's check if we are currently processing last node of the 1st K group. It will be our head node to return
                    if(count == k && i == k-1) ans = prev;
                }
            }
            count++;
        }

        return ans;


    }
    private static void doSwap(Map<Integer, ListNode> nodeMap, int left, int right, ListNode nextToRight) {
        while (left < right) {
            //Put node at left index in temp
            ListNode temp = nodeMap.get(left);
            //Swap the nodes at left and right indexes
            nodeMap.put(left, nodeMap.get(right));
            nodeMap.put(right, temp);

            //Update next node for current node at left index
            nodeMap.get(left).next = nodeMap.get(left+1);

            //Update next node to the left of the node at our left index
            if(left - 1 >= 0) nodeMap.get(left -1).next = nodeMap.get(left);

            //Update next node for current node at right index , if node at right index is the last, update next to null
            if(right  + 1 < nodeMap.size()) nodeMap.get(right).next = nodeMap.get(right+1);
            else nodeMap.get(right).next = nextToRight;
            nodeMap.get(right - 1).next = nodeMap.get(right); //Update next node for node to the left of the node at our right index

            //Increment left pointer and decrement right pointer
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode newHead = new ReverseNodesInKGroup().reverseKGroupV2(head, 2);
        while (newHead != null) {
            System.out.print(newHead.val + ", ");
            newHead = newHead.next;
        }
    }
}
