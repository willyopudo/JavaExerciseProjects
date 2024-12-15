package com.demos.generic;

import java.util.HashSet;

public class Solution {
//    public int solution(int A, int B) {
//        // Let's define Binary search boundaries
//        int l = 1; int r = Math.max(A, B); // Upper bound is the largest stick length
//        int ans = 0;
//
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//
//            // Confirm if we can make at least 4 sticks of equal length  = mid
//            if (isSquarePossible(A, B, mid)) {
//                //Update return answer which is the side length
//                ans = mid;
//                //Increment left boundary to try for a larger side length
//                l = mid + 1;
//            } else {
//                //Decrement right boundary to try for a smaller side length
//                r = mid - 1;
//            }
//        }
//
//        return ans;
//    }

//    private boolean isSquarePossible(int a, int b, int l) {
//        //We divide to get how many 'mid' lengths we can get
//        int ca = a / l;
//        int cb = b / l;
//
//        // Check if we can form at least 4 sticks
//        return (ca + cb) >= 4;
//    }
public int solution(int[] A, int[] B) {
    int n = A.length;  // Total number of candies
    int maxCoins = n / 2;  // Coins available for each shop
    HashSet<Integer> uniqueCandies = new HashSet<>();

    // First shop: Spend maxCoins golden coins on unique candies
    for (int i = 0; i < n && uniqueCandies.size() < maxCoins; i++) {
        uniqueCandies.add(A[i]);
    }
    int temp = uniqueCandies.size();
    // Second shop: Spend maxCoins silver coins on additional unique candies
    for (int i = 0; i < n && uniqueCandies.size() < temp + maxCoins; i++) {
        uniqueCandies.add(B[i]);
    }

    // The size of the set gives the total number of unique candies
    return uniqueCandies.size();
}

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {2,2,2,2};
        int[] arr2 = {7, 4, 2, 5};
        System.out.println( solution.solution(arr1, arr2));
    }
}
