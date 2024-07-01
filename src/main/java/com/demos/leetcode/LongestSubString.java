package com.demos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        //Solution 01
        int left = 0;
        int right = 1;
        int max = 1;
        if(s == null || s.isEmpty())
            return 0;
        if(s.length() == 1)
            return 1;
        while(right < s.length()) {
            if(s.substring(left, right).indexOf(s.charAt(right)) == -1){
                max = Math.max(max, right - left + 1);
                right++;
            }
            else {
                left++;
                right = left + 1;
            }
        }
        return max;
        /*
        Input: s = "abcabcbb"
        dddf
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
         */
    }
}
