package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * #stocks
 ****************************/
public class BuySellStocks {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));

    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int profitIfSoldToday, bestCaseProfit = 0;
        int leastValueSoFar = Integer.MAX_VALUE;
        for (int priceToday : prices) {
            if (priceToday < leastValueSoFar) {
                leastValueSoFar = priceToday;
            }
            profitIfSoldToday = priceToday - leastValueSoFar;
            if (profitIfSoldToday > bestCaseProfit) {
                bestCaseProfit = profitIfSoldToday;
            }
        }
        return bestCaseProfit;
    }

    // A greedier solution
    public static int maxProfitGreedy(int[] prices) {
        int bestCaseProfit = 0;
        int leastValueSoFar = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > leastValueSoFar) {
                bestCaseProfit = Math.max(bestCaseProfit, prices[i] - leastValueSoFar);
            } else {
                leastValueSoFar = prices[i];
            }
        }
        return bestCaseProfit;
    }
}
