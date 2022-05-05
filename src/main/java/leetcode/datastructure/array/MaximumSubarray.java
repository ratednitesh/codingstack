package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/maximum-subarray/
 ****************************/
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
    }

    // Kadane's Algorithm
    // Start traversing your array keep each element in the sum and every time keep the max of currSum and prevSum.
    //But the catch here is that if at any point sum becomes negative then no point keeping it because 0 is obviously greater than negative, so just make your sum 0.
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;
    }

}
