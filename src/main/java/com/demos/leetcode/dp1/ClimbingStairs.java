package com.demos.leetcode.dp1;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
 */
public class ClimbingStairs {
    public int climbStairs(int n) {

        /*
        Intuition :
        If you're on the ( n )-th step, you could have arrived there from the ( (n-1) )-th step (by taking 1 step) or from the ( (n-2) )-th step (by taking 2 steps). So, the number of distinct ways to reach the ( n )-th step is the sum of the ways to reach the ( (n-1) )-th step and the ( (n-2) )-th step. This forms a Fibonacci sequence where each step depends on the previous two steps.

        Approach :
        Base Cases:
        If ( n = 1 ), there is only 1 way to reach the top.
        If ( n = 2 ), there are 2 ways to reach the top.
        Recursive Relation:
        For ( n > 2 ), the number of ways to reach step ( n ) is the sum of the ways to reach step ( n-1 ) and step ( n-2 ).
        Iterative Solution:
        Use two variables to store the ways to reach the previous two steps and update them iteratively until reaching the ( n )-th step.
        Solving Steps :
        Initialize two variables to represent the base cases for the first two steps.
        Loop from 3 up to ( n ), updating the two variables to hold the ways to reach the current step.
        Return the number of ways when you reach the ( n )-th step.
         */

        if (n <= 2) return n;
        int left = 1, right = 2;
        int temp = 0;

        for (int i = 3; i <= n; i++) {
            temp = left + right;
            left = right;
            right = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(7));
    }
}
