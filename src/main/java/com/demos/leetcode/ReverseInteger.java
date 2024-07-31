package com.demos.leetcode;
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */
public class ReverseInteger {
    public int reverse(int x) {
        /*
        To reverse a number:
        First, we find the remainder of the given number by using the modulo (%) operator.
        Multiply the variable reverse by 10 and add the remainder into it.
        Divide the number by 10.
        */

        long rev = 0;
        while(x != 0)
        {
            int remainder = x % 10;
            rev = rev * 10 + remainder;
            x = x/10;
        }
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
            return 0;
        return Long.valueOf(rev).intValue();
    }
}
