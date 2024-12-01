package com.demos.leetcode.arraysandstrings;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1 ) return nums.length;
        //Solution 1 : Brute force - Fo each index, iterate next inexes until we reach an index with a value greater than current value and update it as value at the next immediate index i + 1
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
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0,1}));
    }
}
