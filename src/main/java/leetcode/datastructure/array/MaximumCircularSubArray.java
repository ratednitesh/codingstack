package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 ****************************/
public class MaximumCircularSubArray {
    public static void main(String[] args) {

    }

    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = Integer.MIN_VALUE;
        int localMaxSum = 0;
        int minSum = Integer.MAX_VALUE;
        int localMinSum = 0;
        for (int n : nums) {
            total += n;
            localMaxSum += n;
            localMinSum += n;
            if (localMaxSum > maxSum)
                maxSum = localMaxSum;
            if (localMinSum < minSum)
                minSum = localMinSum;
            if (localMinSum > 0)
                localMinSum = 0;
            if (localMaxSum < 0)
                localMaxSum = 0;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    // Refer: https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
    public int maxSubarraySumCircularOpt(int[] A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
