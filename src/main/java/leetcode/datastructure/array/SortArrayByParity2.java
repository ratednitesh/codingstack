package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 ****************************/
public class SortArrayByParity2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 != 0) {
                j += 2;
            }
            if (i < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
