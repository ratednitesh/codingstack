package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 ****************************/
class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioningDPOpt(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }

    // Recursive Solution
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        return maxSumAfterPartitioning(arr, k, 0);
    }

    public static int maxSumAfterPartitioning(int[] arr, int k, int index) {
        if (index == arr.length)
            return 0;
        int currMax = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            int currIndex = index + i;
            if (currIndex >= arr.length)
                break;
            currMax = Math.max(currMax, arr[currIndex]);
            int leftSum = currMax * (i + 1);
            int rightSum = maxSumAfterPartitioning(arr, k, currIndex + 1);
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }

    // Memoization solution
    public static int maxSumAfterPartitioningDP(int[] arr, int k) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int[] memo = new int[arr.length];
        return maxSumAfterPartitioningDP(arr, k, 0, memo);
    }

    public static int maxSumAfterPartitioningDP(int[] arr, int k, int index, int[] memo) {
        if (index == arr.length)
            return 0;
        if (memo[index] != 0)
            return memo[index];
        int currMax = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            int currIndex = index + i;
            if (currIndex >= arr.length)
                break;
            currMax = Math.max(currMax, arr[currIndex]);
            int leftSum = currMax * (i + 1);
            int rightSum = maxSumAfterPartitioningDP(arr, k, currIndex + 1, memo);
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return memo[index] = maxSum;
    }

    // Bottom Up Approach
    public static int maxSumAfterPartitioningDPOpt(int[] arr, int k) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int currMax = 0;
            int maxSum = 0;
            for (int j = 0; j < k && i + j < n; j++) {
                currMax = Math.max(currMax, arr[i + j]);
                int leftSum = currMax * (j + 1);
                int rightSum = dp[i + j + 1];
                maxSum = Math.max(maxSum, leftSum + rightSum);
            }
            dp[i] = Math.max(maxSum, dp[i]);
        }
        return dp[0];
    }
}
