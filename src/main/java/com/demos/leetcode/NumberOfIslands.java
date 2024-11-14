package com.demos.leetcode;

/*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



    Example 1:

    Input: grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
    Output: 1
    Example 2:

    Input: grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    Output: 3


    Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //validate grid
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        //initialize count
        int count = 0;

        /* Nested loop to iterate through  all indexes looking for a '1', if we encounter a '1',
        increment the counter and call breadth first search recursively on all adjacent nodes */
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfsFunc(grid, i, j);
                }
            }
        }
        return count;
    }
    //Set value at passed index to '0', also check any neighbors with value '1' and set them to zero recursively until exit condition is met
    private void bfsFunc(char[][] grid, int i, int j) {
        //Check boundaries to form exit condition
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

        grid[i][j] = '0';

        //run bsfFunc on neighbor indexes
        bfsFunc(grid, i - 1, j);
        bfsFunc(grid, i + 1, j);
        bfsFunc(grid, i, j - 1);
        bfsFunc(grid, i, j + 1);

    }
}
