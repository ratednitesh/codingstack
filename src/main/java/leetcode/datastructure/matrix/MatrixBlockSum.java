package main.java.leetcode.datastructure.matrix;
/***************************
* https://leetcode.com/problems/matrix-block-sum/
****************************/
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k){
        // range sum
        int m = mat.length, n = mat[0].length;
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0), c1 = Math.max(j - k, 0), r2 = Math.min(i + k + 1, m), c2 = Math.min(j + k + 1, n);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }
        }
        return ans;
    }
}
