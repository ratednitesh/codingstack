package main.java.leetcode.datastructure.array;

import java.util.Stack;

/***************************
 * https://leetcode.com/problems/132-pattern/
 ****************************/
public class LowHighMidPattern {
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{9, 8, 3, 5, 6, 8, 2, 4,}));
    }

    // O(N^2) solution
    public static boolean find132patternBF(int[] nums) {
        if (nums.length < 3) return false;
        for (int i = 1; i < nums.length - 1; i++) {
            int min1 = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                min1 = Math.min(min1, nums[j]);
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (min1 < nums[j] && nums[j] < nums[i])
                    return true;
            }
        }
        return false;
    }


    // O(N) solution using Stack
    public static boolean find132patternSt(int[] nums) {
        if (nums.length < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int mid = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < mid)
                return true;
            else while (stack.size() != 0 && nums[i] > stack.peek()) {
                mid = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    // O(N) without stack
    public static boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int mid = Integer.MIN_VALUE, top = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (mid > nums[i]) return true;
            else while (top < nums.length && nums[i] > nums[top]) {
                mid = nums[top++];
            }
            nums[--top] = nums[i];
        }
        return false;

    }
}
