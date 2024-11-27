package com.demos.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.



    Example 1:

    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
    Example 2:

    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false


    Constraints:

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= Math.max(i - maxLen - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Boolean[] memo = new Boolean[s.length()]; // Tracks "can we split from this start index?"
//        return wordBreakRecursive(s, wordDict, memo, 0);
//    }

    private boolean wordBreakRecursive(String s, List<String> wordDict, Boolean[] memo, int start) {
        if (start == s.length()) {
            return true; // Reached the end successfully
        }
        if (memo[start] != null) {
            return memo[start]; // Return cached result
        }

        for (String word : wordDict) {
            if (s.startsWith(word, start)) { // Check if the substring starts with the current word
                if (wordBreakRecursive(s, wordDict, memo, start + word.length())) {
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false; // Mark as unbreakable from this index
        return false;
    }
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        //wordDict.add("rs");
        //wordDict.add("r");
        //wordDict.add("cat");
        System.out.println(wb.wordBreak("leetcode", wordDict));
    }
}
