package main.java.leetcode.operations.dynamicProgramming;

import java.util.Stack;

/***************************
 * https://leetcode.com/problems/longest-valid-parentheses/
 ****************************/
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())((()()())"));
    }

    public static int longestValidParentheses(String s) {
        int length = 0;
        Stack<Integer> stack = new Stack<>();
        char[] c = s.toCharArray();
        int n = c.length;
        int currentStart = 0;
        for (int i = 0; i < n; i++) {

            if (c[i] == '(')
                stack.push(i);
            else if (!stack.isEmpty()) {
                stack.pop();
                if (stack.isEmpty())
                    length = Math.max(length, i - currentStart + 1);
                else
                    length = Math.max(length, i - stack.peek());
            } else {
                currentStart = i + 1;
            }
        }
        return length;
    }
    // TODO: DP solution
}
