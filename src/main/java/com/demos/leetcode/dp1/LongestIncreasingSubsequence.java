package com.demos.leetcode.dp1;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n ; j++) {
                if (nums[i] < nums[j]) dp[i] = Math.max(dp[i], 1 + dp[j]);
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,2,4,3}));
    }
}
