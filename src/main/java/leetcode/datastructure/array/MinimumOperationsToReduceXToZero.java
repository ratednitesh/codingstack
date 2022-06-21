package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 ****************************/
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1, 1, 4, 2, 3}, 5));
    }

    public static int minOperations(int[] nums, int x) {
        // find the longest subArray whose sum is = sum - x. The remaining elements needs to be removed to find the answer.
        int maxLength = -1;
        if (x == 0)
            return 0;
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum < x)
            return -1;
        if (sum == x)
            return nums.length;
        int currSum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (l <= r && currSum > sum - x) { // current sum is greater than maxLength start removing elements from left unless sum is less than or equal to sum -x.
                currSum -= nums[l++];
            }
            if (currSum == sum - x) // current subArray sum is equal to sum - x.
                maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

}
