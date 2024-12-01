package com.demos.leetcode.tree;

import java.util.*;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
//Using stack of Pair of Treenode and integer to denote current node's depth

//        if (root == null) return 0;
//        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//        stack.push(new Pair<>(root, 1));
//        int maxDepth = 0;
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> current = stack.pop();
//            TreeNode node = current.getKey();
//            int depth = current.getValue();
//            if (node != null) {
//                maxDepth = Math.max(maxDepth, depth);
//                stack.push(new Pair<>(node.left, depth + 1));
//                stack.push(new Pair<>(node.right, depth + 1));
//            }
//        }
//        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));
    }
}
