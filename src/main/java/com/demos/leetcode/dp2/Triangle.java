package com.demos.leetcode.dp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

    Example 1:

    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
       2
      3 4
     6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
    Example 2:

    Input: triangle = [[-10]]
    Output: -10


    Constraints:

    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -104 <= triangle[i][j] <= 104
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.getFirst().getFirst();

        int n = triangle.size();
        //Initialize a dynamic programming array to contain min possible path for each index
        int[][] dp = new int[n][n];
        //Initialize min value to MAX INTEGER for later comparison
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){ //go through each row
            for(int j = 0; j < triangle.get(i).size(); j++){ //go through each column in a row
                //Get value at current index [i][j]
                int val = triangle.get(i).get(j);

                //Check if we are in the beginning of row
                if(j - 1 < 0){
                    //If yes, and a row exists in the top of current row,
                    // the only possible path to this index is from the index directly on top of it, [i-1][j]
                    if(i -1 >= 0) val += dp[i-1][j];
                }
                else{ //If we are not in beginning of the row
                    //Check if an index is not present directly on top of our current index,
                    //if yes, the only possible path to this index is from the index 1 step left of index at it's top [i-1][j-1]
                    if(j > triangle.get(i - 1).size() - 1) val += dp[i-1][j-1];
                    //Otherwise let's get the minimum between path values of [i-1][j-1] and dp[i-1][j]
                    else val += Math.min(dp[i-1][j-1], dp[i-1][j]);
                }
                dp[i][j] = val; //Set value for dp at current index

                //If we are in the last row, keep comparing the lowest value with this value so we do not have to sort the array later
                if(i == n-1) min = Math.min(min, val);
            }
        }
        return min;
    }
    //Using recursion
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp =  new int [n][n];
        for(int [] i: dp) Arrays.fill(i,-1);
        return solve (0,0,n,triangle,dp);
    }
    int solve(int i, int j,int n, List<List<Integer>> triangle,int [][] dp){

        if(i>=n||j>=n) return (int)(1e9);

        if(i==n-1) return triangle.get(i).get(j);

        if(dp[i][j]!=-1) return dp[i][j];

        int down = triangle.get(i).get(j)+ solve(i+1,j,n,triangle,dp);
        int diagonal = triangle.get(i).get(j)+ solve(i+1,j+1,n,triangle,dp);

        return dp[i][j] = Math.min(down,diagonal);
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        List<List<Integer>> triangleVals = new ArrayList<>();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<Integer> triangleVal1 = new ArrayList<>();
        triangleVal1.add(2);

        List<Integer> triangleVal2 = new ArrayList<>();
        triangleVal2.add(3);
        triangleVal2.add(4);

        List<Integer> triangleVal3 = new ArrayList<>();
        triangleVal3.add(6);
        triangleVal3.add(5);
        triangleVal3.add(7);

        List<Integer> triangleVal4 = new ArrayList<>();
        triangleVal4.add(4);
        triangleVal4.add(1);
        triangleVal4.add(8);
        triangleVal4.add(3);

        triangleVals.add(triangleVal1);
        triangleVals.add(triangleVal2);
        triangleVals.add(triangleVal3);
        triangleVals.add(triangleVal4);
        System.out.println(triangle.minimumTotal2(triangleVals));
    }
}
