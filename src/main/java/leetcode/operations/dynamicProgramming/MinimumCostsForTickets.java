package main.java.leetcode.operations.dynamicProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 ****************************/
public class MinimumCostsForTickets {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        System.out.println(minCostTicketsDP4(days, costs));
    }
    // Approach 1. Find the cost for each day of the year. Answer for 365th day will be your answer.
    // For any given day, if it is a day of travel:
    // cost = Minimum( cost of per day pass + cost of yesterday, cost of 7day pass
    //                  + cost of 7days back, cost of 30 day pass + min cost  30 days back  )
    // if not a day of travel, cost = yesterday's cost

    public static int minCostTicketsDP1(int[] days, int[] costs) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : days)
            hs.add(n);
        int[] minCost = new int[366];
        for (int i = 1; i < 366; i++) {
            if (hs.contains(i)) {
                minCost[i] = Math.min(minCost[i - 1] + costs[0],
                        Math.min(minCost[Math.max(0, i - 7)] + costs[1], minCost[Math.max(0, i - 30)] + costs[2]));
            } else {
                minCost[i] = minCost[i - 1];
            }
        }
        return minCost[365];
    }

    // Approach 2: Optimized solution for approach 1:
    // a. We need not iterate from day 1 to day 365 but min and max of travel days
    // b. we need not to keep track of all 365 days but just 30 days.
    public static int minCostTicketsDP2(int[] days, int[] costs) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : days)
            hs.add(n);
        int min = days[0];
        int max = days[days.length - 1];
        int[] minCost = new int[30];
        for (int i = min; i <= max; i++) {
            if (hs.contains(i)) {
                minCost[i % 30] = Math.min(minCost[(i - 1) % 30] + costs[0],
                        Math.min(minCost[Math.max(0, (i - 7) % 30)] +
                                costs[1], minCost[Math.max(0, (i - 30) % 30)] + costs[2]));

            } else {
                minCost[i % 30] = minCost[(i - 1) % 30];
            }
        }
        return minCost[max % 30];
    }

    // Approach 3: Calculate only for the travel Days.
    // For each travel day, starting from the first one, check what will be the min cost, if purchased one, 7 or 30 days pass.
    // Maintain a queue for each pass, if day exceeds the pass limit, remove it from queue. Keep the oldest pass of each type at the top of the queue.
    public static int minCostTicketsDP3(int[] days, int[] costs) {
        Queue<int[]> sevenDaysPass = new LinkedList<>();
        Queue<int[]> thirtyDaysPass = new LinkedList<>();
        int totalCost = 0;
        for (int day : days) {
            while (!sevenDaysPass.isEmpty() && sevenDaysPass.peek()[0] + 7 <= day)
                sevenDaysPass.poll();
            sevenDaysPass.offer(new int[]{day, totalCost + costs[1]});
            while (!thirtyDaysPass.isEmpty() && thirtyDaysPass.peek()[0] + 30 <= day)
                thirtyDaysPass.poll();
            thirtyDaysPass.offer(new int[]{day, totalCost + costs[2]});
            totalCost = Math.min(totalCost + costs[0],
                    Math.min(sevenDaysPass.peek() != null ? sevenDaysPass.peek()[1] : 0,
                            thirtyDaysPass.peek() != null ? thirtyDaysPass.peek()[1] : 0));
        }
        return totalCost;
    }

    // Approach 4: Trying to optimize Approach 2. MOST OPTIMIZED SOLUTION!
    public static int minCostTicketsDP4(int[] days, int[] costs) {
        int min = days[0];
        int max = days[days.length - 1];
        int[] minCost = new int[30];
        int count = 0;
        for (int i = min; i <= max; i++) {
            if (i == days[count]) {
                minCost[i % 30] = Math.min(minCost[(i - 1) % 30] + costs[0],
                        Math.min(minCost[Math.max(0, (i - 7) % 30)] +
                                costs[1], minCost[Math.max(0, (i - 30) % 30)] + costs[2]));
                count++;
            } else {
                minCost[i % 30] = minCost[(i - 1) % 30];
            }
        }
        return minCost[max % 30];
    }
}
