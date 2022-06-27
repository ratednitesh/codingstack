package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 ****************************/
public class BuySellStocksWithCoolDown {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        // if bought today can sell anytime in future
        // if sell today cannot buy next day
     /*
     For each of them we make an array, buy[n], sell[n] and rest[n].
        buy[i] means before day i what is the maxProfit for any sequence end with buy.
        sell[i] means before day i what is the maxProfit for any sequence end with sell.
        rest[i] means before day i what is the maxProfit for any sequence end with rest.

        Then we want to deduce the transition functions for buy sell and rest. By definition we have:
        buy[i]  = max(rest[i-1]-price[i], buy[i-1])
        sell[i] = max(buy[i-1]+price[i], sell[i-1])
        rest[i] = max(sell[i-1], buy[i-1], rest[i-1])

        Where price is the price of day i. All of these are very straightforward. They simply represents :

        (1) We have to `rest` before we `buy` and
        (2) we have to `buy`

        One tricky point is how do you make sure you sell before you buy, since from the equations it seems that [buy, rest, buy] is entirely possible.

        Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). That made sure [buy, rest, buy]
         is never occurred.

        A further observation is that and rest[i] <= sell[i] is also true therefore

        rest[i] = sell[i-1]
        Substitute this in to buy[i] we now have 2 functions instead of 3:

        buy[i] = max(sell[i-2]-price, buy[i-1])
        sell[i] = max(buy[i-1]+price, sell[i-1])
        This is better than 3, but

        we can do even better

        Since states of day i relies only on i-1 and i-2 we can reduce the O(n) space to O(1). And here we are at our final solution:
      */
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

    //recursive solution
    int maxProfit = 0;

    public int maxProfitRecursive(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] dp = new int[prices.length];
        Arrays.fill(dp, -1);
        return getMaxProfit(prices, 0, dp);
    }

    private int getMaxProfit(int[] prices, int pos, int[] dp) {
        if (pos >= prices.length) {
            return 0;
        }

        //if already calculated, just return
        if (dp[pos] != -1) {
            return dp[pos];
        }

        int maxProfit = 0;
        for (int i = pos + 1; i < prices.length; i++) {
            int diff = prices[i] - prices[pos];
            if (diff > 0) {
                //Selling the stock bought at pos
                int profit = getMaxProfit(prices, i + 2, dp) + diff;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        //skip buying stock at pos
        int profit = getMaxProfit(prices, pos + 1, dp);
        maxProfit = Math.max(maxProfit, profit);
        dp[pos] = maxProfit;

        return maxProfit;
    }
}
