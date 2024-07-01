package com.demos.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node to simplify the code
        ListNode sample = new ListNode(0);
        // Use temp to traverse the result list
        ListNode tail = sample;
        int carry = 0;

        // Iterate through the lists and the carry
        while (l1 != null || l2 != null || carry == 1)
        {
            // Calculate the sum of current digits and carry
            int sum = 0;
            if (l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            // Update carry for the next calculation
            carry = sum / 10;

            // Create a new node with the current digit and add it to the result list
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }

        // Return the result list starting from the next of the dummy node
        return sample.next;
    }
}

