package com.demos.leetcode;

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
