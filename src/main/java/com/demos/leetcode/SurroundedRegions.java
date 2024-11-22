package com.demos.leetcode;

import java.util.Arrays;

/*
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.



Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:

images/leetcode/surrounded-regions.png

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]



Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {
    private char[][] board;
    private int R, C;

    public void solve(char[][] board) {
        this.board = board;
        R = board.length;
        C = board[0].length;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                // only iterate over the edge cells
                if (row == 0 || col == 0 || row == R-1 || col == C-1) {
                    if (board[row][col] == 'O') {
                        //Run dfs on each 'O' cell
                        dfsFunc(row, col);
                    }
                }

            }
        }

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (board[row][col] == 'E') {
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

        System.out.println(Arrays.deepToString(board));
    }


    private void dfsFunc(int row, int col) {

        if (row < 0 || row >= R || col < 0 || col >= C || board[row][col] == 'X' || board[row][col] == 'E') {
            return;
        }

        board[row][col] = 'E';

        // up
        dfsFunc(row-1, col);
        // down
        dfsFunc(row+1, col);
        // left
        dfsFunc(row, col-1);
        // right
        dfsFunc(row, col+1);

    }

    public static void main(String[] args) {
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        new SurroundedRegions().solve(board);
    }
}
