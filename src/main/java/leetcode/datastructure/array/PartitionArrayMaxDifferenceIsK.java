package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
* https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
****************************/
public class PartitionArrayMaxDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0], n = nums.length;
        int i = 1;
        int count = 1;
        while (i < n) {
            if (nums[i] - min > k) {
                min = nums[i];
                count++;
            }
            i++;
        }
        return count;
    }
}
