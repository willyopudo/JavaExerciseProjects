package com.demos.leetcode;

/*
Given the root of a binary tree, invert the tree, and return its root.

Example  : images/leetcode/invert-binary-tree.png
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/


import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    //Using recursion
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        //Swap left and right nodes of the root node
//        TreeNode right = root.right;
//        TreeNode left = root.left;
//
//        //Invert the other nodes recursively
//        root.left = invertTree(right);
//        root.right = invertTree(left);
//
//        return root;
//    }

    //Using Queue with level order traversal (breadth-first-traversal)

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap the left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to the queue if they are not null
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return root;
    }
}
