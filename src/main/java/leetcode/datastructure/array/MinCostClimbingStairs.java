package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 ****************************/
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(arr));
    }

    // DP with extra space
    public static int minCostClimbingStairsDP(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = 0;
        minCost[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
        }
        return minCost[cost.length];
    }

    // DP with no extra space
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) return 0;
        int minCostSecondLast = 0;
        int minCostLast = 0;
        int minCost = 0;
        for (int i = 2; i <= cost.length; i++) {
            minCost = Math.min(minCostLast + cost[i - 1], minCostSecondLast + cost[i - 2]);
            minCostSecondLast = minCostLast;
            minCostLast = minCost;
        }
        return minCost;
    }
}
