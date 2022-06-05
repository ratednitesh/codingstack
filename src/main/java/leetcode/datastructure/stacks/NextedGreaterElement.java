package main.java.leetcode.datastructure.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/***************************
 * https://leetcode.com/problems/next-greater-element-i/
 ****************************/
public class NextedGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) { // iterate over num2
            while (!stack.isEmpty() && stack.peek() < n)
                hm.put(stack.pop(), n); // for each element in stack set the next greater element as value.. update the value if further greater found
            stack.push(n); // push each num in num2 to stack
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static int[] nextGreaterElementOpt(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : nums1)
            hm.put(n, -1);
        Stack<Integer> stack = new Stack<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n)
                hm.put(stack.pop(), n); // for each element in stack set the next greater element as value.. update the value if further greater found
            stack.push(n);
            if (hm.containsKey(n)) {
                stack.push(n);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
