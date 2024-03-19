package com.demos.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumLeetCode {
    public int[] twoSum(int[] nums, int target) {
        //Brute force
//        int sum = 0;
//        int[] indices = new int[]{};
//        for(int i =0; i<nums.length; i++){
//            for(int j =i+1; j<nums.length; j++){
//                sum = nums[i] +nums[j];
//                if(sum == target) {
//                    indices = new int[]{i,j};
//                    break;
//                }
//            }
//        }
//        return indices;


        //Using 2 pass Hash Table
        Map<Integer,    Integer> numberMap = new HashMap<>();
        int n  = nums.length;

        for(int i =0; i< n; i++){
            numberMap.put(nums[i], i);
        }

        //Find complement
        for(int i = 0; i<n; i++){
            int complement = target - nums[i];
            if(numberMap.containsKey(complement) && numberMap.get(complement) != i){
                return new int[]{i, numberMap.get(complement)};
            }
        }
        return new int[]{};


        //Using one pass HashTable
    }
}
