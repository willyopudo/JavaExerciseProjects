package com.demos.leetcode.dp2;

/*
    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Example 1:
    Image : images/leetcode/maximal-square.png
    Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
    Output: 4

    Example 2:
    Input: matrix = [["0","1"],["1","0"]]
    Output: 1

    Example 3:
    Input: matrix = [["0"]]
    Output: 0


    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is '0' or '1'.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //If the input matrix is empty or has no columns, the function immediately returns 0 because no squares can exist.
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        //A 2D array where dp[i][j] represents the side length of the largest square ending at cell (i, j)
        int[][] dp = new int[rows][cols];
        //Tracks the side length of the largest square found during the computation.
        int maxSide = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //Perform calculations only on cells with value '1'
                if (matrix[i][j] == '1') {
                    //If the cell is in the first row or column (i == 0 or j == 0), the largest square ending at (i, j) can only have a side length of 1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        /* For other cells, the size of the square ending at (i, j) depends on the minimum square size among:
                           1. dp[i-1][j] (above cell),
                           2. dp[i][j-1] (left cell),
                           3. dp[i-1][j-1] (top-left diagonal cell), plus 1(this cell).

                         */
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    //After computing dp[i][j], update maxSide if the current square is larger than the previously found largest square.
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        //Return area (side squared)
        return maxSide * maxSide;
    }
}
