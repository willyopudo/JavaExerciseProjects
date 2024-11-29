package com.demos.leetcode.arraysandstrings;

/*
    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.
    Example 2:

    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.


    Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.
 */
public class FirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int index = -1;
        //starting from each character of haystack, check if successive needle.length chars are similar to needle characters
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                //If any chars do not match, break out of inner loop
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
                else //Check if current
                if (j == n - 1) return i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        FirstOccurrenceInString f = new FirstOccurrenceInString();
        System.out.println(f.strStr("helloworld", "world"));
    }
}
