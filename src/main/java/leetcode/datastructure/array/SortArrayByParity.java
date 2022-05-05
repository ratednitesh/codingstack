package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 *
 ****************************/
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(arr)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            if (nums[start] % 2 == 1) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                start++;
            }
        }
        return nums;
    }
}
