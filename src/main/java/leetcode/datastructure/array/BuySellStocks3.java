package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 ****************************/
public class BuySellStocks3 {
    // Attempting generic solution
    // References: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
    public int maxProfit(int[] prices) {
        int firstBuyEndingMaxProfit = Integer.MIN_VALUE, secondBuyEndingMaxProfit = Integer.MIN_VALUE;
        int firstSellEndingMaxProfit = 0, secondSellEndingMaxProfit = 0;
        for (int price : prices) {
            secondSellEndingMaxProfit = Math.max(secondSellEndingMaxProfit, secondBuyEndingMaxProfit + price);
            secondBuyEndingMaxProfit = Math.max(secondBuyEndingMaxProfit, firstSellEndingMaxProfit - price);
            firstSellEndingMaxProfit = Math.max(firstBuyEndingMaxProfit + price, firstSellEndingMaxProfit);
            firstBuyEndingMaxProfit = Math.max(firstBuyEndingMaxProfit, -price);
        }
        return secondSellEndingMaxProfit;
    }
}
