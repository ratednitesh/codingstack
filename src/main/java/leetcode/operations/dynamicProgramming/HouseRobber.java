package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/house-robber/
 ****************************/
public class HouseRobber {
    public static void main(String[] args) {

    }

    // approach 1: pure DP
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] mark = new int[nums.length];
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            mark[i] = Math.max(nums[i] + mark[i - 2], mark[i - 1]);
        }
        return mark[nums.length - 1];
    }

    // Approach 2: refined DP
    public static int robOptimized(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int rob = 0; //max money can get if rob current house
        int notRob = 0; //max money can get if not rob current house

        for (int i = 0; i < nums.length; i++) {
            int currRob = nums[i] + notRob; //if rob current value, previous house must not be robbed
            notRob = Math.max(notRob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currRob; // current Rob saved to rob to be used in next iteration.
        }
        return Math.max(rob, notRob);
    }
}
