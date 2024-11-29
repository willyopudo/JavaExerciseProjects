package com.demos.leetcode.arraysandstrings;

public class RotateArray {

    /* Brute force solution : Compute the remainder by k % n, that is the actual number of rotations we should do.
       Put values which should be rotated  in a temp array nums2
       Then copy the remaining values which were not touched
       Finally copy all nums2 array values to nums array.

     */
//    public void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int[] nums2 = new int[n];
//        int x = k % n; //remainder
//
//        int y = 0;
//        while (y < x) {
//            nums2[x - y - 1] = nums[n - 1 - y];
//            y++;
//        }
//        if (n - x >= 0) System.arraycopy(nums, 0, nums2, x, n - x);
//        System.arraycopy(nums2, 0, nums, 0, n);
//
//    }


    //Solution 2 : best space complexity (O(n))
    /*
        1. Calculate Effective Rotations:

        The length of the array is n = len(nums).
        The number of rotations k is updated to k % n to handle cases where k is greater than n. This ensures that rotating the array n times results in the same array, so any extra rotations beyond n can be ignored.
        k %= len(nums)
        Define the Reverse Function:

        A helper function reverse is defined to reverse the elements of the array between indices left and right.
        Within this function, a while loop swaps elements from the start (left) and end (right) of the specified segment, moving towards the center until left is no longer less than right.

        2. Reverse the Entire Array:

        The entire array is reversed from index 0 to len(nums) - 1.
        This step places the elements that need to be rotated to the front.
        reverse(0, len(nums) - 1)

        3. Reverse the First k Elements:

        The first k elements of the reversed array are reversed back to their original order.
        This places the rotated elements at the start of the array in their correct positions.
        reverse(0, k - 1)

        4. Reverse the Remaining n-k Elements:

        The remaining elements from index k to len(nums) - 1 are reversed back to their original order.
        This places the rest of the elements in their correct positions.
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 2);
    }
}
