package com.demos.leetcode.arraysandstrings;

/*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
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
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).


    Constraints:
    1 <= nums.length <= 3 * 104
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1 ) return nums.length;
        //Solution 1 : Brute force - Fo each index, iterate next indexes until we reach an index with a value greater than current value and update it as value at the next immediate index i + 1
        //Runs 4 ms
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] >= nums[i + 1]) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] > nums[i]) {
//                        nums[i + 1] = nums[j];
//                        if(j == nums.length - 1) return i + 2;
//                        break;
//                    }
//                    else{
//                        if(j == nums.length - 1) return i + 1;
//                    }
//                }
//            }
//        }
//        return nums.length;

        //Simpler solution
        //Initialize minimum value as nums[0] since array is sorted
        int min = nums[0];
        //Initialize index to be updated next in case we encounter a larger number
        int index = 1;

        for (int i = 1; i < nums.length; i++) { //start iterating from index 1 to end of array

            //If we get a number greater than current minimum, update value at index to this number , update minimum, increment index
            if (nums[i] > min) {
                nums[index] = nums[i];
                min = nums[index];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
