package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/maximum-product-subarray/
 ****************************/
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int left = 0, right = 0, n = nums.length, maxProduct = nums[0];
        for (int i = 0; i < n; i++) {
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[n - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(left, right));
        }
        return maxProduct;
    }

    int maxProduct(int A[], int n) {
        // store the result that is the max we have found so far
        int r = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }


            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}
