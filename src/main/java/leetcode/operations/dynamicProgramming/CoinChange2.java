package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/coin-change-2/
 ****************************/
public class CoinChange2 {
    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[]{1, 2, 5}));
    }

    // recursion + memoization
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        return changeDP(amount, coins, 0, dp);
    }

    public int changeDP(int amount, int[] coins, int start, int[][] dp) {
        if (amount == 0)
            return 1;
        int count = 0;

        for (int i = start; i < coins.length; i++) {
            if (amount >= coins[i]) {
                if (dp[amount - coins[i]][i] != 0)
                    return dp[amount - coins[i]][i];
                count += changeDP(amount - coins[i], coins, i, dp);
            }
        }
        return dp[amount][start] = count;
    }

    // dp
    public int changeDP(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    // dp O(1) space
    public int changeDPOpt(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
