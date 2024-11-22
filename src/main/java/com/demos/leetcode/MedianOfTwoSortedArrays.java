package com.demos.leetcode;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int[] arr3 = new int[nums1.length + nums2.length];

        // Traverse both array
        while (i<n1 && j <n2)
        {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (nums1[i] < nums2[j])
                arr3[k++] = nums1[i++];
            else
                arr3[k++] = nums2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = nums1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = nums2[j++];



        double median = 0.0;

        if(arr3.length % 2 == 0) {
            int firstIndex = arr3.length / 2 -1;
            int secondIndex = firstIndex + 1;
            median = (arr3[firstIndex] + arr3[secondIndex]) / 2.0;
        }
        else
            median = arr3[arr3.length / 2];

        return median;
    }

}
