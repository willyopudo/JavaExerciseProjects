package com.demos.leetcode.tree;

/*
    You are given the root of a binary tree containing digits from 0 to 9 only.

    Each root-to-leaf path in the tree represents a number.

    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

    A leaf node is a node with no children.

    Example 1:
    Image: images/leetcode/sum-root-to-leaf-numbers-01.png
    Input: root = [1,2,3]
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

    Example 2:
    Image: images/leetcode/sum-root-to-leaf-numbers-02.png
    Input: root = [4,9,0,5,1]
    Output: 1026
    Explanation:
    The root-to-leaf path 4->9->5 represents the number 495.
    The root-to-leaf path 4->9->1 represents the number 491.
    The root-to-leaf path 4->0 represents the number 40.
    Therefore, sum = 495 + 491 + 40 = 1026.


    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 9
    The depth of the tree will not exceed 10.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return doSum(root, root.val);

        //Possible solution using Queue and hashmap to store node cumulative values
//        int sum = 0;
//        Queue<TreeNode> q = new LinkedList<>();
//        Map<TreeNode, Integer> parentVals = new HashMap<>();
//        parentVals.put(root, root.val);
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            TreeNode cur = q.poll();
//            if (cur.left == null && cur.right == null) sum += (parentVals.get(cur);
//            if (cur.left != null){
//                q.add(cur.left);
//                parentVals.put(cur.left, parentVals.get(cur) * 10 + cur.left.val);
//            }
//            if (cur.right != null) {
//                q.add(cur.right);
//                parentVals.put(cur.right, parentVals.get(cur) * 10 + cur.right.val);
//            }
//        }
//        return  sum;
    }
    //Optimal recursive solution which gets cumulative sum to the leftmost leaves and add to cumulative sums of rightmost leaves
    //Runs in 0(N) time complexity, space complexity = O(1)
    private int doSum(TreeNode  node, int pVal) {
        //If both left and right are null, return parent node value
        if (node.left == null && node.right == null) return pVal;
        //Initialize left sum and right sum
        int sumLeft = 0, sumRight = 0;
        //If left node is not null, we proceed to process it child nodes recursively
        if(node.left != null)
            sumLeft += doSum(node.left, pVal * 10 + node.left.val); //Multiply parent Val by 10 because we have moved deeper one level, add it to value of currentNode.left
        if(node.right != null)
            sumRight += doSum(node.right, pVal * 10 + node.right.val); //Multiply parent Val by 10 because we have moved deeper one level, add it to value of currentNode.right
        return sumLeft + sumRight;
    }
    public static void main(String[] args) {
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(sumRootToLeafNumbers.sumNumbers(root));
    }

}
