package com.demos.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {

        //Solution 1 - Brute force
//        int maxArea = 0;
//        int left = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            int right = height.length - 1;
//            while (i < right) {
//                int area = Math.min(height[i], height[right]) * (right - i);
//                maxArea = Math.max(maxArea, area);
//                if (height[i] < height[right]) {
//                    break;
//                }
//                right--;
//            }
//        }
//        return maxArea;

        //Solution 2 - Use one while loop
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
