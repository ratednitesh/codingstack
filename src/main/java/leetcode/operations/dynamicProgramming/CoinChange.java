package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/coin-change/
 ****************************/
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
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
}
