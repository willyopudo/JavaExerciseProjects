package com.demos.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    //Solution 1 : Brute force approach using for loop O(N)
    public List<String> summaryRanges(int[] nums) {
//        int n = nums.length;
//        if(n == 0) return new ArrayList<>();
//        List<String> result = new ArrayList<>();
//        if(nums.length == 1) {result.add(nums[0] + ""); return result;}
//
//        int rangeStart = 0;
//        for (int i = 0; i < n; i++) {
//            if (i == n - 1 || nums[i] + 1 != nums[i + 1]) {
//                if(i == n -1) result.add( (rangeStart == i) ? nums[rangeStart] + "" : nums[rangeStart] + "->" + nums[i]);
//                else result.add( (i - rangeStart == 0) ? nums[rangeStart] + "" : nums[rangeStart] + "->" + nums[i]);
//                rangeStart = i + 1;
//            }
//        }
//        return result;

        //Best solution using while loop. Runs in 0ms
        List<String> list = new ArrayList<>() ;
        int n = nums.length ;
        for(int i=0 ; i<n ;++i){
            StringBuilder rs = new StringBuilder() ;
            rs.append( nums[i] ) ;
            boolean flag = false ;
            int last = -1 ;
            while( i+1 < n && nums[i+1] == nums[i]+1 ){
                ++i ;
                flag = true ;
                last = nums[i] ;
            }
            if( flag ){
                rs.append( "->" ) ;
                rs.append(last) ;
            }
            list.add( rs.toString() ) ;
        }
        return list ;
    }
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        System.out.println(s.summaryRanges(new int[]{-3,-2,2}));
    }
}
