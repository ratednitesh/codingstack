package main.java.leetcode.operations.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 ****************************/
public class CountSortedVowelStrings {
    public static void main(String[] args) {
        System.out.println(countVowelStringsDP(2));
    }

    // Approach 1: Using Backtracking
    public static int countVowelStringsBT(int n) {
        if (n == 0) return 0;
        List<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        String letters = "aeiou";
        backTrack(result, letters, curr, 0, n);
        System.out.println(result);
        return result.size();
    }

    public static void backTrack(List<String> result, String letters, StringBuilder curr,
                                 int start, int n) {
        if (curr.length() == n)
            result.add(curr.toString());
        else {
            for (int i = start; i < 5; i++) {
                curr.append(letters.charAt(i));
                backTrack(result, letters, curr, i, n);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

    // Approach 2: Using mathematics
    private static int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }

    // Approach 3: Using DP
    private static int countVowelStringsDP(int n) {
        int[] dp = new int[6];
        for (int i = 1; i < dp.length; i++)
            dp[i] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 5; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[5];
    }
}
