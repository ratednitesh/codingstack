package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 ****************************/
public class SpecialArray {
    public static void main(String[] args) {
        System.out.println(specialArrayOptBS(new int[]{0, 0}));
    }

    public static int specialArray(int[] nums) {
        if (nums.length == 1)
            return nums[0] == 0 ? -1 : 1;
        int x = nums.length;
        int[] counts = new int[x + 1];

        for (int elem : nums)
            if (elem >= x)
                counts[x]++;
            else
                counts[elem]++;

        int res = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            res += counts[i];
            if (res == i)
                return i;
        }
        return -1;
    }

    public static int specialArrayBS(int[] nums) {
        Arrays.sort(nums);
        for (int x = 1; x <= nums.length; x++) { // we need to find the number x such that there are x numbers greater than or equal to x
            // means x can be minimum of 1
            // and max of nums.length
            int index = findFirstGreaterOrEqual(x, nums); // find the first index greater than or equal to x or 'i'
            if (nums.length - index == x)
                return x;
        }
        return -1;
    }

    private static int findFirstGreaterOrEqual(int x, int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < x)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    // Optimized Binary Search Solution
    public static int specialArrayOptBS(int[] nums) {
        Arrays.sort(nums);
        // find the index x which satisfies below conditions:
        // nums[x]>= nums.length - x
        // and nums[x-1] < nums.length - x
        int left = 0, right = nums.length, len = right;
        while (left < right) {
            int x = (left + right) / 2;
            if (nums[x] < len - x) {
                left = x + 1;
            } else {
                if (x == 0 || nums[x - 1] < len - x)
                    return len - x;
                else
                    right = x;
            }
        }

        return -1;
    }


}
