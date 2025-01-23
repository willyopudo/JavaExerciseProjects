package com.demos.leetcode.arraysandstrings;

import java.util.Arrays;

/*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Constraints:
    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
 */
public class MajorityElement {
    //Runs in 5ms - O(NLogN)
    public int majorityElement(int[] nums) {
        //Declare variables
        int mid = nums.length / 2;
        int left = 0,right = 1;

        //Sort array
        Arrays.sort(nums);
        //We are going to use two pointers, left and right
        while (right <= nums.length) {
            //We compute only if our current integer is different form the previous, or if we reach limit of the array
            if (right == nums.length || nums[right] != nums[right-1] ){

                //Compute number of elements between right - 1 and left , add 1 to it for inclusivity
                int count = right-1 - left + 1;
                //Push left to where right is currently
                left = right;
                //If value of count is greater than mid, return
                if (count > mid) return nums[right-1];
            }
            //Increment right
            right++;
        }

//        for (int num : nums) {
//            map.compute(num, (k, num2) -> num2 != null ? num2 + 1 : 1);
//            if (map.get(num) > mid) {
//                return num;
//            }
//        }
        return nums[0];
    }
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3}));
    }
}
