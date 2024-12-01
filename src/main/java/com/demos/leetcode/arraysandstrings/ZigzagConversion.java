package com.demos.leetcode.arraysandstrings;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        //Validate input string
        if(numRows == 1) return s;

        //Create string builder array of size numRows passed
        StringBuilder[] sbs = new StringBuilder[numRows];

        //We initialize row and direction variables to zero, we will use these to move back and forth as we append characters to our sting builders
        int row = 0, dir = 0;

        //Initialize new string builders inside sbs array
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //Increment/Decrement row based on value of dir
            //dir is always either 0,1,-1
            row += dir;

            //append character to the current row computed above
            sbs[row].append(c);

            /*
                Check if we are in the first or lats row
                If direction is 0, update to 1 (positive i.e moving downwards)
                If direction is = 1 update to -1(negative i.e moving back upwards)
                This enables us to populate our string builders in a zigzag manner

             */

            if(row ==0 || row == numRows - 1) {
                dir = (dir == 0) ? 1 : -dir;
            }
        }
        return convert(sbs);
    }
    //Utility function to convert string builder array to string builder and return resulting string
    private String convert(StringBuilder[] sbs) {
        StringBuilder res = new StringBuilder();

        for(StringBuilder sb : sbs) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}
