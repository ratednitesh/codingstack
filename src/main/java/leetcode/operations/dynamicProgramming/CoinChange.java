package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/coin-change/
 ****************************/
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChangeRecur(new int[]{186, 419, 83, 408}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;
        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : Math.min(temp, min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    // TODO: Using recursion


    public static int coinChangeRecur(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int res = coinChange(coins, amount, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int coinChange(int[] coins, int amount, int length, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int temp;
                if (dp[amount - coin] != 0)
                    temp = dp[amount - coin];
                else {
                    temp = coinChange(coins, amount - coin, length + 1, dp);
                }
                if (temp != Integer.MAX_VALUE)
                    res = Math.min(res, temp + 1);
            }
        }
        return dp[amount] = res;
    }

    // DP
    public static int coinChangeDP(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = -1;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    int temp = dp[i - coin] + 1;
                    min = min == -1 ? temp : Math.min(min, temp);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
