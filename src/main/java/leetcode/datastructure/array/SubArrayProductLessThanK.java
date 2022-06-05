package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/subarray-product-less-than-k/
 ****************************/
public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

    // Sliding Window
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        // as all numbers in the array are positive
        if (k <= 1) return 0;

        // initialize some vars
        int prod = 1, res = 0, left = 0;

        // traversing through each window
        for (int right = 0; right < nums.length; right++) {

            // store the product of elements which we see new in window
            prod *= nums[right];

            // if product is greater than the given k
            // then slide the window by doing left++ and dividing prod by nums[left]
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }

            // this res will have number of subarrays(windows) possible
			/* I/p: [ 10, 5, 2, 6 ], k = 100

				right = left = 0;
				prod = prod * 10 = 10;
				res = res + 0 - 0 + 1 = 1;  // subarrays - [ 10 ]

				right = 1;
				prod = prod * 5 = 10 * 5 = 50
				res = res + 1 - 0 + 1 = 1 + 1 - 0 + 1 = 3; // subarrays - [ 10 ], [ 5 ], [ 10, 5 ]

				right = 2;
				prod = prod * 2 = 50 * 2 = 100;
				prod > k;
				prod = prod / nums[left] = prod / nums[0] = 100 / 10 = 10;
				left++;
				res = res + 2 - 1 + 1 = 3 + 2 = 5; // subarrays - [ 10 ], [ 5 ], [ 10, 5 ], [ 2 ], [ 5, 2 ]
			*/
            res += right - left + 1;
        }
        return res;
    }
}
