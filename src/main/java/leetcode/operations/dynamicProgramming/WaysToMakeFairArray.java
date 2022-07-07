package main.java.leetcode.operations.dynamicProgramming;
/***************************
* https://leetcode.com/problems/ways-to-make-a-fair-array/
****************************/
public class WaysToMakeFairArray {
    public int waysToMakeFair(int[] A) {
        int res = 0, n = A.length, left[] = new int[2], right[] = new int[2];
        for (int i = 0; i < n; i++)
            right[i%2] += A[i];
        for (int i = 0; i < n; i++) {
            right[i%2] -= A[i];
            if (left[0]+right[1] == left[1]+right[0]) res++;
            left[i%2] += A[i];
        }
        return res;
    }
    // Top Down : TLE
    public int waysToMakeFairTD(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        int count = 0;
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * helper(nums, i, 0))
                count++;
        }
        return count;
    }

    int[] dp;

    public int helper(int[] nums, int ignoredIndex, int index) {

        if (index == ignoredIndex || index == ignoredIndex + 1)
            index++;
        if (index >= nums.length)
            return 0;
        if (dp[index] != 0)
            return dp[index];
        int sum = nums[index] + helper(nums, ignoredIndex, index + 2);
        if (index > ignoredIndex)
            dp[index] = sum;
        return sum;
    }
    // Recursion
    public int waysToMakeFairRecur(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * helper2(nums, i, 0))
                count++;
        }
        return count;
    }

    public int helper2(int[] nums, int ignoredIndex, int index) {

        if (index == ignoredIndex || index == ignoredIndex + 1)
            index++;
        if (index >= nums.length)
            return 0;
        return nums[index] + helper(nums, ignoredIndex, index + 2);
    }
}
