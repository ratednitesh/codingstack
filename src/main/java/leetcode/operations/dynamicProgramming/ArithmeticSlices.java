package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/arithmetic-slices/
 ****************************/
public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int subSets = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            if (nums[i + 2] - nums[i + 1] == diff)
                subSets += extendAP(nums, diff, i + 3, 1);
        }
        return subSets;
    }

    private int extendAP(int[] nums, int diff, int index, int count) {
        while (index < nums.length && nums[index] - nums[index - 1] == diff) {
            count++;
            index++;
        }
        return count;
    }

    // DP solution
    public int numberOfArithmeticSlicesDP(int[] nums) {
        if (nums.length < 3)
            return 0;
        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }

}
