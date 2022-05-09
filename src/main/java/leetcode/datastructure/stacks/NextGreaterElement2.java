package main.java.leetcode.datastructure.stacks;

import java.util.Arrays;
import java.util.Stack;

/***************************
 * https://leetcode.com/problems/next-greater-element-ii/
 ****************************/
public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        if (nums.length == 1) return new int[]{-1};
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n)
                stack.push(i);
        }
        return result;
    }
}
