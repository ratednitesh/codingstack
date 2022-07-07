package main.java.leetcode.operations.dynamicProgramming;
/***************************
* https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
****************************/
public class SpaceWasted {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        Integer[][] dp = new Integer[nums.length][k+1];
        n = nums.length;
        return helper(nums, k, 0, dp);
    }

    int n, INF = (int) (200 * 1e6);

    private int helper(int[] nums, int k, int index, Integer[][] dp) {
        if (index == n)
            return 0;
        if (k < 0)
            return INF;
        if (dp[index][k] != null)
            return dp[index][k];
        int ans = INF, max = nums[index], total = 0;
        for (int i = index; i < n; i++) {
            max = Math.max(nums[i], max);
            total += nums[i];
            int wasted = max * (i - index + 1) - total;
            ans = Math.min(ans, helper(nums, k - 1, i + 1, dp) + wasted);
        }
        return dp[index][k] = ans;
    }

    // Approach 2
    Integer[][] memo = new Integer[200][200];
    public int minSpaceWastedKResizing2(int[] nums, int k) {
        n = nums.length;
        return dp(nums, 0, k);
    }
    int dp(int[] nums, int i, int k) {
        if (i == n) return 0;
        if (k == -1) return INF;
        if (memo[i][k] != null) return memo[i][k];
        int ans = INF, maxNum = nums[i], totalSum = 0;
        for (int j = i; j < n; ++j) {
            maxNum = Math.max(maxNum, nums[j]);
            totalSum += nums[j];
            int wasted = maxNum * (j - i + 1) - totalSum;
            ans = Math.min(ans, dp(nums, j + 1, k - 1) + wasted);
        }
        return memo[i][k] = ans;
    }
}
