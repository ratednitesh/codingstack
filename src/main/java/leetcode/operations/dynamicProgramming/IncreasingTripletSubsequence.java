package main.java.leetcode.operations.dynamicProgramming;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 ****************************/
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    // O(2^N) -- TODO: verify complexity.
    public static boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        for (int i = nums.length - 3; i >= 0; i--) {
            if (backTrack(nums, i, nums[i], 1))
                return true;
        }
        return false;
    }

    public static boolean backTrack(int[] nums, int index, int currVal, int len) {
        if (index == nums.length)
            return false;
        if (len == 3)
            return true;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > currVal) {
                if (backTrack(nums, i, nums[i], len + 1))
                    return true;
            }

        }
        return false;
    }

    // Brute Force: O(n^3)
    public boolean increasingTripletBF(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l - 2; i++) {
            for (int j = i + 1; j < l - 1; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k])
                        return true;
                }
            }
        }
        return false;
    }

    // O(N)
    public boolean increasingTripletSimple(int[] nums) {
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        left[0] = nums[0];
        for (int i = 1; i < l; i++) { //Find left min
            left[i] = Math.min(nums[i], left[i - 1]);
        }
        right[l - 1] = nums[l - 1];
        for (int i = l - 2; i >= 0; i--) { //Find right max
            right[i] = Math.max(nums[i], right[i + 1]);
        }
        for (int i = 0; i < l; i++) {
            if (left[i] < nums[i] && nums[i] < right[i])
                return true;
        }
        return false;
    }

    // Longest Increasing Subsequence Solution
    public boolean increasingTripletLIS(int[] nums) {
        int[] dp = new int[3];
        int len = 0;

        for (int n : nums) {
            int index = Arrays.binarySearch(dp, 0, len, n);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = n;
            if (index == len) len++;
            if (len == 3) return true;
        }
        return false;
    }

    // Optimal: T.C. O(n)     S.C O(1)
    public boolean increasingTripletOpt(int[] nums) {
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        //take assumption : left < right
        for (int n : nums) {
            //Test each number one by one comparing First with left and then with right
            if (n <= left) left = n; // keep the smallest number so far in left.
            else if (n <= right) right = n;  // If n is LTET right, means n is surely GT left
            else return true; // If n is GTET left and GTET right that means we got the increasing triplet
        }
        return false;
    }
}
