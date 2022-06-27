package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/minimum-falling-path-sum/
 ****************************/
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
    }

    // recursive solution + memoization
    public int minFallingPathSum(int[][] matrix) {
        int minFallSum = Integer.MAX_VALUE;
        int n = matrix.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            minFallSum = Math.min(minFallSum, minimumSum(matrix, 0, i));
        }
        return minFallSum;
    }

    int[][] dp;

    public int minimumSum(int[][] matrix, int row, int column) {
        if (row < 0 || column < 0 || row == matrix.length || column == matrix.length)
            return 0;
        if (dp[row][column] != 0)
            return dp[row][column];
        int sum = matrix[row][column];
        return dp[row][column] = sum + Math.min(minimumSum(matrix, row + 1, column),
                Math.min(column - 1 >= 0 ? minimumSum(matrix, row + 1, column - 1) : Integer.MAX_VALUE, column + 1 < matrix.length ? minimumSum(matrix, row + 1, column + 1) : Integer.MAX_VALUE));
    }
    // TODO: Bottom Up Approach
}
