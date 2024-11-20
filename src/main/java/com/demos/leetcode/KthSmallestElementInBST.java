package com.demos.leetcode;

import java.util.*;

/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Examples:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 */

public class KthSmallestElementInBST {

    //Solution 1 : (Slow O(n + mlogm)) - Traverse the tree using BFS and add each node value to unsorted list. Sort the list and return value at index k-1
    /*int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            TreeNode curr = queue.poll();
            list.add(curr.val);

            // Enqueue left child
            if (curr.left != null) {
                queue.add(curr.left);
            }

            // Enqueue right child
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        List<Integer> sortedList = list.stream().sorted().toList();
        return sortedList.get(k - 1);
    }
    */

    int kthSmallest(TreeNode root, int k) {
        // Initialize a Stack for iterative traversal
        Stack<TreeNode> stack = new Stack<>();
        int pos = 1;
        int val = 0;

        // Loop until either the current node is not null or the stack is not empty
        while (root != null || pos <= k) {
            // Traverse to the leftmost node and push each encountered node onto the stack
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Pop the last node from the stack (most recently left-visited node)
            root = stack.pop();

            //Check if our current position matches value of k and assign value to be returned to current node value
            if(pos == k) val = root.val;

            //Increment position
            pos++;

            // Move to the right subtree to continue the in-order traversal
            root = root.right;
        }
        return val;
    }
}
