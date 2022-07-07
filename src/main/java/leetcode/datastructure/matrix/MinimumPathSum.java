package main.java.leetcode.datastructure.matrix;
/***************************
* https://leetcode.com/problems/minimum-path-sum/
****************************/
public class MinimumPathSum {
    public int minPathSum(int[][] grid){
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        return findMinPathSum(grid, m, n, 0, 0);
    }

    int[][] dp;

    private int findMinPathSum(int[][] grid, int m, int n, int row, int column) {
        if (row == m - 1 && column == n - 1)
            return grid[row][column];
        if (dp[row][column] != 0)
            return dp[row][column];
        int currentVal = grid[row][column];
        int sum = Integer.MAX_VALUE;
        if (row != m - 1) {
            sum = findMinPathSum(grid, m, n, row + 1, column);
        }
        if (column != n - 1) {
            sum = Math.min(sum, findMinPathSum(grid, m, n, row, column + 1));
        }
        return dp[row][column] = currentVal + sum;
    }
}
