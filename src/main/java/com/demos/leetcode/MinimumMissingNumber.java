package com.demos.leetcode;

import java.util.Arrays;
/*
    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MinimumMissingNumber {
    public int minimumMissingNumber(int[] nums) {
        Arrays.sort(nums);
        int cur = 0;
        for (int num : nums) {
            if (num > 0 && num > cur + 1) return cur + 1;
            cur = Math.max(num, 0);
        }
        return cur > 0 ? cur + 1 : 1;
    }
    public static void main(String[] args) {
        MinimumMissingNumber m = new MinimumMissingNumber();
        System.out.println(m.minimumMissingNumber(new int[]{-3, -1,0, 4, 3, 2}));
    }
}
