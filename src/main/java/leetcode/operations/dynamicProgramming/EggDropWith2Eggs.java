package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 ****************************/
public class EggDropWith2Eggs {
    public static void main(String[] args) {
        System.out.println(new EggDropWith2Eggs().twoEggDropDP(100));
    }

    // Recursive Solution
    public int twoEggDrop(int n) {
        int minMoves = n;
        if (n == 0)
            return 0;
        for (int i = 1; i <= n; i++)
            minMoves = Math.min(minMoves, 1 + Math.max(i - 1, twoEggDrop(n - i))); // best of worst
        return minMoves;
    }

    // memoization - top down
    int[] dp = new int[1001];

    public int twoEggDropTD(int n) {
        if (dp[n] == 0) {
            for (int i = 1; i <= n; i++) {
                dp[n] = Math.min(dp[n] == 0 ? n : dp[n], 1 + Math.max(i - 1, twoEggDropTD(n - i)));
            }
        }
        return dp[n];
    }

    // DP - Bottom Up Approach
    public int twoEggDropDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = i;
            for (int j = 1; j <= i; j++) {
                min = Math.min(min, 1 + Math.max(j - 1, dp[i - j]));
            }
            dp[i] = min;
        }
        return dp[n];
    }
    //TODO: mathematical approach

}
