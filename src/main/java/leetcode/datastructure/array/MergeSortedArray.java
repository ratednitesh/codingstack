package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/merge-sorted-array/
 ****************************/
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 0, 0, 0};
        merge(arr, 3, new int[]{2, 4, 6}, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;

        while (m >= 1 && n >= 1) {
            nums1[m + n - 1] = (nums1[m - 1] > nums2[n - 1]) ? nums1[m-- - 1] : nums2[n-- - 1];
        }
        while (n >= 1)
            nums1[m + n - 1] = nums2[n-- - 1];

    }
}
