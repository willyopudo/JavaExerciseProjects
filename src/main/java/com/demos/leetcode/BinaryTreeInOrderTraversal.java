package com.demos.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return printInorder(root, list);
    }
    // Function to print inorder traversal
    public static List<Integer> printInorder(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return list;

        // First recur on left subtree
        printInorder(node.left, list);

        // Now deal with the node
        list.add(node.val);

        // Then recur on right subtree
        printInorder(node.right, list);
        return list;
    }
}
