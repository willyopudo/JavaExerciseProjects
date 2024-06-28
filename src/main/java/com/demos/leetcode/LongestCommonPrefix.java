package com.demos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //Solution 01
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            int count = 0;
            for (String str : strs) {
                if (str.length() > i && str.charAt(i) == strs[0].charAt(i)) {
                    count++;
                }

            }
            if(count == strs.length){
                sb.append(strs[0].charAt(i));
            }
            else
                break;

        }

        return sb.toString();

        //Solution 02
        /*
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
        */

        /*
        Input: strs = ["cir","car"]
        Output: "fl"
        */


    }
}
