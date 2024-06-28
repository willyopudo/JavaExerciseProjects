package com.demos.leetcode;

import java.util.ArrayList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();


        while(l1 != null){
            s1.insert(0, l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.insert(0, l2.val);
            l2 = l2.next;
        }
        String sumStr = String.valueOf(Integer.parseInt(s1.toString()) + Integer.parseInt( s2.toString()));
        ListNode sumListNode = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(sumStr.length()-1))));
        for(int i = sumStr.length()-2; i >= 0; i--){
            ListNode prev;
            ListNode next =  null;
            ListNode current =new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i))));

            if(i > 0)
                next =new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i-1))));

            if (i == sumStr.length() - 2) {
                prev = sumListNode;
            }
            else
                prev = new ListNode(Integer.parseInt(String.valueOf(sumStr.charAt(i + 1))));
            prev.next = current;
            current.next = next;

        }
        return sumListNode;


        //System.out.println(sum);
    }
}

