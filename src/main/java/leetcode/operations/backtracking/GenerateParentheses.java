package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/generate-parentheses/
 ****************************/
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, result, "", 0, 0);
        return result;
    }

    private static void backTrack(int n, List<String> result, String str, int start, int end) {
        if (str.length() == n * 2) {
            result.add(str);
        } else {
            if (start < n)
                backTrack(n, result, str + "(", start + 1, end);
            if (end < start)
                backTrack(n, result, str + ")", start, end + 1);
        }
    }
}
