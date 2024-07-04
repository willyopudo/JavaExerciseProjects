package com.demos.leetcode;

import java.util.*;

public class ThreeSumV2 {
    //Recursion to get all permutations of 3 sets of elements in array
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        int r = 3;
        int n = nums.length;
        int index = 0;

        int[] data = new int[r];
        // Get all combination using temporary array 'data[]'
        resSet = combinationUtil(nums, data, 0, n-1, 0, r, new HashSet<>());
        return new ArrayList<>(resSet);
    }
    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Starting and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static Set<List<Integer>> combinationUtil(int[] arr, int[] data, int start,
                                              int end, int index, int r, Set<List<Integer>> resSet)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            List<Integer> integerList = new ArrayList<>();
            int sum = 0;
            if (data[r-1] + data[r-2] + data[r-3] == 0) {
                for (int j=0; j<r; j++) {
                    integerList.add(data[j]);
                    integerList.sort(Comparator.naturalOrder());
                }
            }
            //System.out.println(integerList.toString());
            if(!integerList.isEmpty())
                resSet.add(integerList);
            return resSet;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r, resSet);
        }
        return resSet;
    }
}
