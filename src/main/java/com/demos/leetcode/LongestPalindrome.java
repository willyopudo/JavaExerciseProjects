package com.demos.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        //First attempt
        //Start from highest substring and look for palindrome as we decrease sliding window length

//        int n = s.length();
//        int max = 0;
//        String longest = "";
//        //int left = 0;
//        if(n == 1)
//            return s;
//        for(int i = n-1; i >= 0; i--) {
//            int left = 0;
//            int right = left + i;
//            while(right < n){
//                String str = s.substring(left, right  + 1);
//                if (isPalindrome(str)) {
//                    return str;
//                }
//                left++;
//                right++;
//            }
//
//        }
//        return longest;


        //Manacher's Algorithm
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);
        s = "#" + s.replaceAll("", "#") + "#";
        int[] dp = new int[s.length()];
        int center = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length() && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxStr;

    }
    public static boolean isPalindrome(String str) {
        // base case
        if (str.isEmpty() || str.length() == 1)
            return true;

        // check first and last characters
        if (str.charAt(0) != str.charAt(str.length()-1))
            return false;

        // check the remaining string
        return isPalindrome(str.substring(1, str.length()-1));
    }
}
