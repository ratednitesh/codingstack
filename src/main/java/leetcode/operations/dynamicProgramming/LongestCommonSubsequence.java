package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/longest-common-subsequence/
 ****************************/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[m][n];
    }
}
