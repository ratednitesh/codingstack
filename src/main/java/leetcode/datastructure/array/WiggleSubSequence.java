package main.java.leetcode.datastructure.array;

/***************************
* https://leetcode.com/problems/wiggle-subsequence/
****************************/
public class WiggleSubSequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // max of taking the next one as increasing or decreasing + 1
        return 1 + Math.max(recurseHelper(nums, 1, 0, true), recurseHelper(nums, 1, 0, false));
    }

    public int recurseHelper(int[] nums, int current, int prev, boolean positive) {
        if (current < 0 || current >= nums.length || prev < 0 || prev >= nums.length) {
            return 0;
        }
        // if the diff between prev and current should be positive,
        if (positive) {
            // yes, it is positive, increment and change it to negative
            if (nums[prev] > nums[current]) {
                return 1 + recurseHelper(nums, current + 1, current, !positive);
            } else {
                // its not positive. try the next element
                return recurseHelper(nums, current + 1, current, positive);
            }
        } else {
            // if the diff between prev and current should be negative,
            if (nums[prev] < nums[current]) {  // yes, it is negative, increment and change it to positive
                return 1 + recurseHelper(nums, current + 1, current, !positive);
            } else {
                // its not negative. try the next element
                return recurseHelper(nums, current + 1, current, positive);
            }
        }
    }
}
