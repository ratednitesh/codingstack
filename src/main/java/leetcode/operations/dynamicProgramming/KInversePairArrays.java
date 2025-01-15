package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/k-inverse-pairs-array/
 ****************************/
public class KInversePairArrays {
    // TODO: understand below code fully
    // https://leetcode.com/problems/k-inverse-pairs-array/discuss/104815/Java-DP-O(nk)-solution
    public static int kInversePairs(int n, int k) {
        int mod = 1000000007; // modulo for large answers
        if (k > n * (n - 1) / 2 || k < 0) return 0; // k can be max nC2
        if (k == 0 || k == n * (n - 1) / 2) return 1; // only 1 array - all descending
        long[][] dp = new long[n + 1][k + 1];
        dp[2][0] = 1; // for 2 length array: only one possibility of k =0 -ascending
        dp[2][1] = 1; // for 2 length array: only one possibility of k =0 -descending
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1; // all ascending case
            for (int j = 1; j <= Math.min(k, i * (i - 1) / 2); j++) { // iterate j from 1 to min(k, iC2)
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (j >= i) dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return (int) dp[n][k];
    }
}
