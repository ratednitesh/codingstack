package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/delete-and-earn/
 ****************************/
public class DeleteAndEarn {
    public static void main(String[] args) {

    }

    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for (int n : nums) {
            dp[n] += n;
        }
        int skipLastPoints = 0, takeLastPoints = 0;
        for (int i = 1; i < 10001; i++) {
            int skipCurrentPoints = Math.max(skipLastPoints, takeLastPoints);
            int takeCurrentPoints = skipLastPoints + dp[i];
            skipLastPoints = skipCurrentPoints;
            takeLastPoints = takeCurrentPoints;
        }
        return Math.max(skipLastPoints, takeLastPoints);
    }
}
