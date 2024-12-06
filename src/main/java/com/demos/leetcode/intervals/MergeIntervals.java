package com.demos.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<int[]>();
        int[] firstInterval = intervals[0];
        mergedIntervals.add(firstInterval);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= mergedIntervals.getLast()[1] || intervals[i][0] <= mergedIntervals.getLast()[1]) {
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], intervals[i][1]);
                mergedIntervals.getLast()[0] = Math.min(mergedIntervals.getLast()[0], intervals[i][0]);

            }

            else mergedIntervals.add(intervals[i]);
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

//        Using O(1) Space complexity
//        int k = 0;
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[k][1] >= intervals[i][0]) {
//                intervals[k][1] = Math.max(intervals[k][1], intervals[i][1]);
//            } else {
//                k++;
//                intervals[k] = intervals[i];
//            }
//        }
//        return Arrays.copyOfRange(intervals, 0, k + 1);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{1, 4}, {0, 0}};
        int[][] result = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
