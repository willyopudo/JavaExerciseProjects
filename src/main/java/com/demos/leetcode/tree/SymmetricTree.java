package com.demos.leetcode.tree;

/*
    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

    Example 1:
    Image : images/leetcode/symmetric-tree-01.png
    Input: root = [1,2,2,3,4,4,3]
    Output: true

    Example 2:
    Image: images/leetcode/symmetric-tree-02.png
    Input: root = [1,2,2,null,3,null,3]
    Output: false

    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetrical(root.left, root.right);
    }
    //Recursively compare left nodes to their corresponding right nodes and vise versa
    public boolean isSymmetrical(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null) {
            return false;
        }
        //Check also if left and right node values match
        return l.val == r.val && isSymmetrical(l.left, r.right) && isSymmetrical(l.right, r.left);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(8);

        System.out.println(new SymmetricTree().isSymmetric(root));
    }
}
