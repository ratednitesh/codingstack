package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 ****************************/
public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    // not a good solution
    public static int minSubArrayLen(int target, int[] nums) {
        int length = 1;
        for (int n = 1; n <= nums.length; n++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            int left = 0;
            int right = left + n;

            while (right < nums.length) {
                if (sum >= target)
                    return length;
                sum -= nums[left++];
                sum += nums[right++];
            }
            if (sum >= target)
                return length;
            length++;
        }
        return 0;
    }

    // better solution using sliding window
    public int minSubArrayLenSW(int target, int[] nums) {
// basic constraint checking
        if (nums == null || nums.length == 0)
            return 0;

        // initialization of the start & end index of your sliding window
        int start = 0, end = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while (end < nums.length) {
            // keep a running sum as the end pointer expands your window
            sum += nums[end++];

            // this while loop will be skipped until your window meets the condition that
            // the running sum is equal or greater than the int 's' passed in. aka the window
            // is valid
            while (sum >= target) {
                // now you want to condense your window to find the minimum window as the
                // problem wants

                // updates the min length
                minLength = Math.min(minLength, end - start);

                // this moves your start index by one condensing your window and
                // decreasing the sum to make sure that it's still valid
                sum -= nums[start++];
            }
        }

        // if no min is found, return 0 or else return the min length you found above.
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

