package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 ****************************/
public class BuySellStocks4 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        int[] buyMaxProfit = new int[k + 1], sellMaxProfit = new int[k + 1];
        Arrays.fill(buyMaxProfit, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = k; i > 0; i++) {
                sellMaxProfit[i] = Math.max(buyMaxProfit[i] + price, sellMaxProfit[i]);
                buyMaxProfit[i] = Math.max(buyMaxProfit[i], sellMaxProfit[i - 1] - price);
            }
        }
        return sellMaxProfit[k];
    }

    // Optimized DP Solution // TODO: understand below logic fully: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
    public int maxProfitDP(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    // consider k as infinity if k>= n/2
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
