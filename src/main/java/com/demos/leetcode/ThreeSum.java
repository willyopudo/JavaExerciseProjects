package com.demos.leetcode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right;
            while(left < nums.length -2) {
                if(left == i)
                    left++;
                right = left + 1;
                if(i - left == 1)
                    right = left + 2;

                if(nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(nums[i]);
                    integerList.add(nums[left]);
                    integerList.add(nums[right]);
                    integerList.sort(Comparator.naturalOrder());

                    resSet.add(integerList);
                }
                left++;
            }
        }

        return new ArrayList<>(resSet);

    }
}
