package com.demos.leetcode.tree;

import java.util.*;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<Integer>(); //The integer list to return
//        Stack<TreeNode> stack = new Stack<>(); //Stack variable to track current node during iteration
//        Set<TreeNode> visited = new HashSet<>(); //Set of TreeNodes to store the nodes we have visited
//
//        //Validate if provided root node is null
//        if (root == null) return list;
//
//        //Initialize current and push it to stack
//        TreeNode cur = root;
//        stack.push(cur);
//
//        //Iterate as long as our stack has object(s)
//        while (!stack.isEmpty()) {
//            /*For the current node , as long as it has a left node which is not visited yet, add it to the stack and
//            update current */
//            while (cur != null && cur.left != null && !visited.contains(cur.left)) {
//                stack.push(cur.left);
//                cur = cur.left;
//            }
//            //Once we have reached the farthest left node, add it to visited set if it was not added already
//            //Add value of current node to int list as well if node is not null
//            if(!visited.contains(cur)){
//                visited.add(cur);
//                assert cur != null;
//                list.add(cur.val);
//
//            }
//            else{ // If current node is already visited, pop it out of stack
//                stack.pop();
//            }
//            //Update value of current node
//            cur = stack.isEmpty() ? null : stack.peek();
//
//             //For the current node , as long as it has a right node, and it's left node is either null or already visited
//
//            while (cur != null && cur.right != null && (cur.left == null || visited.contains(cur.left))) {
//                //Pop out the current node from stack because once you traverse to the right node, it means you have visited the parent node
//                TreeNode temp = stack.pop();
//                //Add the popped node to visited set, Add the popped node value to integer list
//                if(!visited.contains(temp)){
//                    visited.add(temp);
//                    list.add(temp.val);
//                }
//                //Push right node to stack
//                stack.push(cur.right);
//                //Update current node value
//                cur = cur.right;
//            }
//        }
//        return list;
//
//        //Uncomment below line to test recursive function
//        //return printInorder(root, list);
//    }
//    // Function to return inorder traversal to integer list
//    public static List<Integer> printInorder(TreeNode node, List<Integer> list)
//    {
//        if (node == null)
//            return list;
//
//        // First recur on left subtree
//        printInorder(node.left, list);
//
//        // Now deal with the node
//        list.add(node.val);
//
//        // Then recur on right subtree
//        printInorder(node.right, list);
//        return list;
//    }

        //Simpler solution
        //Initialize an ArrayList to store the result (in-order traversal)
        List<Integer> res = new ArrayList<>();

        // Initialize a Stack for iterative traversal
        Stack<TreeNode> stack = new Stack<>();

        // Loop until either the current node is not null or the stack is not empty
        while (root != null || !stack.isEmpty()) {
            // Traverse to the leftmost node and push each encountered node onto the stack
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Pop the last node from the stack (most recently left-visited node)
            root = stack.pop();

            // Append the value of the popped node to the result list
            res.add(root.val);

            // Move to the right subtree to continue the in-order traversal
            root = root.right;
        }

        // Return the final result list
        return res;
    }
}
