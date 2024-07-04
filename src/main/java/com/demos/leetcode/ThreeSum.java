package com.demos.leetcode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //For loop with nested while loop - Very bad time complexity
//        Set<List<Integer>> resSet = new HashSet<>();
//        int left = 0;
//        int right;
//        for (int i = 0; i < nums.length - 2; i++) {
//            left = i + 1;
//
//            while(left < nums.length -1) {
//                right = left + 1;
//                while (right < nums.length) {
//                    if (nums[i] + nums[left] + nums[right] == 0) {
//                        List<Integer> integerList = new ArrayList<>();
//                        integerList.add(nums[i]);
//                        integerList.add(nums[left]);
//                        integerList.add(nums[right]);
//                        integerList.sort(Comparator.naturalOrder());
//
//                        resSet.add(integerList);
//                    }
//                    right++;
//                }
//                left++;
//            }
//        }
//
//        return new ArrayList<>(resSet);
        //[-1,0,1,2,-1,-4] - sorted = [-4,-1,-1,0,1,2]
        //Sort Array and skip duplicate elements

        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;

    }
}
