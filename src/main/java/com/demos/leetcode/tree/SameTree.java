package com.demos.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;

        //Initialize 2 stacks for performing breadth first traversal on our trees
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.offer(p);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.offer(q);

        //Loop until any of the stacks is empty
        while (!q1.isEmpty() && !q2.isEmpty()) {
            //Let's do trivial BF traversal simultaneously for both trees
            TreeNode pCurr = q1.poll();
            TreeNode qCurr = q2.poll();
            if(pCurr != null && qCurr != null) {
                //Since we started from root node for both the trees, if we encounter a difference in current pCurr and qCurr node values, return false
                if(pCurr.val != qCurr.val) return false;

                //add left and right nodes to respective stacks
                q1.offer(pCurr.left);
                q1.offer(pCurr.right);
                q2.offer(qCurr.left);
                q2.offer(qCurr.right);
            }
            //If one of the stacks is null while the other is not, we know the trees are starting to differ, so return false
            if((pCurr != null && qCurr == null) || (pCurr == null && qCurr != null)) return false;

        }
        //Finally check if both stacks are empty and return
        return q1.isEmpty() && q2.isEmpty();
    }
    //Solution 2 : Using recursion
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree2(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);

        p.left = new TreeNode(2);
        //p.right = new TreeNode(3);
        //q.left = new TreeNode(2);
        q.right = new TreeNode(2);
        System.out.println(new SameTree().isSameTree2(p, q));
    }
}
