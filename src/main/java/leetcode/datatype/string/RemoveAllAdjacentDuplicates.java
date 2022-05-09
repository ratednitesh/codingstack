package main.java.leetcode.datatype.string;

import java.util.Stack;

/***************************
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 ****************************/
public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("ddeeedbbcccdddbdaaf", 3));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Data> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                if (stack.peek().val + 1 == k) {
                    stack.pop();
                    continue;
                }
                stack.peek().val++;
            } else {
                stack.push(new Data(c, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Data d : stack) {
            while (d.val > 0) {
                sb.append(d.c);
                d.val--;
            }
        }
        return sb.toString();

    }
}

class Data {
    int val;
    char c;

    Data(char c, int val) {
        this.c = c;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Data{" +
                "val=" + val +
                ", c=" + c +
                '}';
    }
}