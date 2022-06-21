package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 ****************************/
public class NumberOfLongestIncreasingSubsequences {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLen = 0, numberOfMaxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) count[i] += count[j];
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (maxLen == dp[i]) {
                numberOfMaxLen += count[i];
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                numberOfMaxLen = count[i];
            }
        }
        return numberOfMaxLen;
    }

   
}
