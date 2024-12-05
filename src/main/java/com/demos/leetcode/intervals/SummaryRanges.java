package com.demos.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    //Solution 1 : Brute force approach using for loop O(N)
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        if(nums.length == 1) {result.add(nums[0] + ""); return result;}
        int prev = 0;
        int count = 1;
        int curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[prev] == 1) {
                count++;
            }
            else{
                if(count == 1) result.add(curr + "");
                else result.add(curr + "->" + nums[prev]);
                curr = nums[i];
                count = 1;
            }
            if(i == nums.length - 1) {
                if(nums[i] - nums[prev] == 1) {
                    result.add(curr + "->" + nums[i]);
                }
                else result.add(nums[i] + "");
            }
            prev = i;
        }
        return result;
    }
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
