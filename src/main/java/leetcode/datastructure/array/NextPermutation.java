package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/next-permutation/
 ****************************/
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int indexFirstDrop = nums.length - 2;
        while (indexFirstDrop > -1 && nums[indexFirstDrop] >= nums[indexFirstDrop + 1]) {
            indexFirstDrop--;
        }
        if (indexFirstDrop == -1)
            reverse(nums, 0, nums.length - 1);
        else {
            int indexFirstHigh = nums.length - 1;
            while (nums[indexFirstDrop] >= nums[indexFirstHigh]) {
                indexFirstHigh--;
            }
            int temp = nums[indexFirstDrop];
            nums[indexFirstDrop] = nums[indexFirstHigh];
            nums[indexFirstHigh] = temp;
            reverse(nums, indexFirstDrop + 1, nums.length - 1);
        }
    }

    private static void reverse(int[] n, int start, int end) {
        while (start < end) {
            int temp = n[start];
            n[start] = n[end];
            n[end] = temp;
            start++;
            end--;
        }
    }
}
