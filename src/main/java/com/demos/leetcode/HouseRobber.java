package com.demos.leetcode;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,10,8,2,10,3,5,10,5,3};
        System.out.println(new HouseRobber().rob(nums));
    }
}
