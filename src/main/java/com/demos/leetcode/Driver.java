package com.demos.leetcode;

import com.demos.leetcode.tree.BinaryTreeInOrderTraversal;
import com.demos.leetcode.tree.TreeNode;

public class Driver {
    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        LongestCommonPrefix test =  new LongestCommonPrefix();
//        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
//
//        ListNode l1 = new ListNode(9);
//        ListNode l1a = new ListNode(9);
//        ListNode l1b = new ListNode(9);
//        ListNode l1c = new ListNode(9);
//        l1.next = l1a;
//        l1a.next = l1b;
//        l1b.next = l1c;
//
//        ListNode l2 = new ListNode(9);
//        ListNode l2a = new ListNode(9);
//        ListNode l2b = new ListNode(9);
//
//        l2.next = l2a;
//        l2a.next = l2b;
//
//        showElements( addTwoNumbers.addTwoNumbers(l1, l2));
//    }
//
//    private static void showElements(ListNode node) {
//        while(node != null){
//            System.out.println(node.val);
//            node = node.next;
//        }
//
//        LongestSubString ls = new LongestSubString();
//        System.out.println(ls.lengthOfLongestSubstring("dvdt"));
        //String s = "cbbd";
        //System.out.println(s.substring(0,2));
    //-1,0,1,2,-1,-4,-2,-3,3,0,4
        //ThreeSum threeSum = new ThreeSum();
        //System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}).toString());

        //MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        //System.out.println(m.findMedianSortedArrays(new int[]{1, 3, 4}, new int[]{2,5,6}));

        //LongestPalindrome lp = new LongestPalindrome();
        //System.out.println(lp.longestPalindrome("ababab"));

        //ZigzagConversion zc = new ZigzagConversion();
        //System.out.println(zc.convert("PAYPALISHIRING", 3));

        //ReverseInteger ri = new ReverseInteger();
        //System.out.println(ri.reverse(-2147483412));

        //ContainerWithMostWater container = new ContainerWithMostWater();
        //System.out.println(container.maxArea(new int[]{1,3,3,4}));
        //TreeNode root = new TreeNode(3);
        //root.right = new TreeNode(2);
        //root.right.left = new TreeNode(1);
        //root.right.right = new TreeNode(4);
        //root.right.right.left = new TreeNode(5);

        BinaryTreeInOrderTraversal bt = new BinaryTreeInOrderTraversal();
        //System.out.println(bt.inorderTraversal(root));
        System.out.println(new Driver().fibonacci(10));

    }
    public int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return n + fibonacci(n - 1);
    }
}
