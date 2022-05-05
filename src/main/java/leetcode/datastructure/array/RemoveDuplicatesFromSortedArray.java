package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 ****************************/
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 6};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    // Two pointer Approach
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
