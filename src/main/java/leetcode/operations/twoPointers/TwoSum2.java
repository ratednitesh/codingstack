package main.java.leetcode.operations.twoPointers;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 ****************************/
public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    // Approach 2: Using two pointer
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
