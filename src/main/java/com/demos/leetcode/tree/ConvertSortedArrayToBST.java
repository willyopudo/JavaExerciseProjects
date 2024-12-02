package com.demos.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertSortedArrayToBST {
    /*
        Choose the Middle Element as Root:
        - For each segment of the array, pick the middle element. This divides the array into two halves that will become the left and right subtrees.
        Recursive Division:
        - Recursively build the left subtree using the left half of the array.
        - Recursively build the right subtree using the right half of the array.
        Base Case:
        - If the current segment is empty, return null, as there are no more elements to process.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return rTreeBuild(nums, 0, nums.length - 1);

    }
    private TreeNode rTreeBuild(int[] nums, int start, int end ) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = rTreeBuild(nums, start, mid - 1);
        root.right = rTreeBuild(nums, mid + 1, end);
        return root;
    }
    public static void main(String[] args) {
        ConvertSortedArrayToBST c = new ConvertSortedArrayToBST();
        TreeNode root =  c.sortedArrayToBST(new int[]{0,1,2,3});

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Loop until either the current node is not null or the stack is not empty
        while (!q.isEmpty()) {
            root = q.poll();
            if(root != null) {
                System.out.print(root.val + ",");
                q.offer(root.left);
                q.offer(root.right);
            }
        }

    }
}
