package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 ****************************/
public class MaximumLengthOfSubArrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int maxLength = 0, positiveCount = 0, negativeCount = 0;
        for (int n : nums) {
            if (n == 0) {
                positiveCount = 0;
                negativeCount = 0;
            } else if (n > 0) {
                positiveCount++;
                negativeCount = negativeCount == 0 ? 0 : negativeCount + 1;
            } else {
                int temp = positiveCount;
                positiveCount = negativeCount == 0 ? 0 : negativeCount + 1;
                negativeCount = temp + 1;
            }
            maxLength = Math.max(maxLength, positiveCount);
        }
        return maxLength;
    }
}
