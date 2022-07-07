package main.java.leetcode.datastructure.matrix;
/***************************
* https://leetcode.com/problems/range-sum-query-2d-immutable/
****************************/
public class NumMatrix {
    int[][] dp;

    // https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/2104317/DP-Visualised-%2B-Interview-Tips DP solution
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return  (dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]);
    }
}
