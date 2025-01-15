package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/out-of-boundary-paths/
 ****************************/
public class OutOfBoundaryPaths {
    /*
    Complexity
    Time: O(m * n * maxMove * 4), where m <= 50 is number of rows, n <= 50 is number of columns, maxMove <= 50.
    Space: O(m * n * maxMove)*/
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return dfs(m, n, maxMove, startRow, startColumn, new Integer[m + 1][n + 1][maxMove + 1]);
    }

    int[][] helperGrid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private int dfs(int m, int n, int maxMove, int r, int c, Integer[][][] dp) {
        if (r < 0 || r == m || c < 0 || c == n) return 1; // Out of bound -> Count 1 way
        if (dp[r][c][maxMove] != null) return dp[r][c][maxMove];
        if (maxMove == 0)
            return 0;
        int ans = 0;
        for (int i = 0; i < 4; ++i) {
            ans = (ans + dfs(m, n, maxMove - 1, r + helperGrid[i][0], c + helperGrid[i][1], dp)) % 1_000_000_007;
        }
        return dp[r][c][maxMove] = ans;
    }
}
