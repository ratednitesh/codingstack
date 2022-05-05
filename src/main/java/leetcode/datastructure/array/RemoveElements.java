package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/remove-element/
 ****************************/
public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        System.out.println(removeElement(arr, 1));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] != val) {
                start++;
            } else if (nums[start] == val && nums[end] != val) {
                nums[start] = nums[end];
                end--;
                start++;
            } else if (nums[start] == val && nums[end] == val) {
                end--;
            }
        }
        return end + 1;
    }
}
