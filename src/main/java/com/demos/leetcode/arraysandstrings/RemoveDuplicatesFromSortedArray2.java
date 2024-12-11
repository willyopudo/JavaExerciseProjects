package com.demos.leetcode.arraysandstrings;

import java.util.Arrays;

/*
    Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

    Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

    Return k after placing the final result in the first k slots of nums.

    Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }
    If all assertions pass, then your solution will be accepted.


    Example 1:
    Input: nums = [1,1,1,2,2,3]
    Output: 5, nums = [1,1,2,2,3,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
    Input: nums = [0,0,1,1,1,1,2,3,3]
    Output: 7, nums = [0,0,1,1,2,3,3,_,_]
    Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:
    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1 ) return nums.length;
        Arrays.sort(nums);
        //Initialize minimum value as nums[0] since array is sorted
        int min = nums[0];
        //Initialize tracker for index of current minimum value
        int prevMinIndex = 0;
        //Initialize index to be updated next in case we encounter a larger number
        int index = 1;

        for (int i = 1; i < nums.length; i++) { //start iterating from index 1 to end of array

            //If we get a number greater than current minimum, or if it is equal to current minimum and is exactly 1 index after min index
            // update value at index to this number , update minimum, increment index
            if (nums[i] > min || (nums[i] == min && i == prevMinIndex + 1)) {
                nums[index] = nums[i];
                //Update prevMinIndex only if nums[i] > min so that condition (nums[i] == min && i == prevMinIndex + 1) can work correctly
                if(nums[i] > min) prevMinIndex = i;
                min = nums[index];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray2 removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray2();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
