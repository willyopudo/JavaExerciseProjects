package com.demos.leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int waysToClimb = 0;
        while(n > 1){
            waysToClimb += 2;
            n -= 2;
        }
        return n == 1 ? waysToClimb + 1 : waysToClimb;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
    }
}
