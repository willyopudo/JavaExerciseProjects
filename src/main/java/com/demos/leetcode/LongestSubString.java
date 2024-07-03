package com.demos.leetcode;

import java.util.*;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        //Solution 3 - Fastest - best time complexity
        //Sliding window with HashMap of last seen index of characters in the string

        int max = 0;
        int left = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            max = Math.max(max, right - left + 1);
            lastSeen.put(c, right);
        }


        //Solution 2 - Second Fastest - Best space complexity
        //CharSet with sliding window

//        int left = 0, right = 0;
//        int max = 0;
//        Set<Character> charSet = new HashSet<>();
//        if(s == null || s.isEmpty())
//            return 0;
//        if(s.length() == 1)
//            return 1;
//        while(right < s.length()) {
//            if(charSet.contains(s.charAt(right))) {
//                max = Math.max(max, charSet.size());
//                charSet.clear();
//                left++;
//                right = left;
//            }
//            else {
//                charSet.add(s.charAt(right));
//                max = Math.max(max, charSet.size());
//                right++;
//            }
//        }

        //Solution 01 - Slowest
        //sliding window utilizing substring and indexOf functions

//        int left = 0;
//        int right = 1;
//        int max = 1;
//        if(s == null || s.isEmpty())
//            return 0;
//        if(s.length() == 1)
//            return 1;
//        while(right < s.length()) {
//            if(s.substring(left, right).indexOf(s.charAt(right)) == -1){
//                max = Math.max(max, right - left + 1);
//                right++;
//            }
//            else {
//                left++;
//                right = left + 1;
//            }
//        }
        return max;
        /*
        Input: s = "abcabcbb"
        dddf
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
         */
    }
}
