package main.java.leetcode.operations.dynamicProgramming;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 ****************************/
public class NumberOfGoodWaysToSplitString {
    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));
    }

    public static int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        char[] c = s.toCharArray();
        int[] alpha = new int[26];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (alpha[c[i] - 'a'] == 0) {
                alpha[c[i] - 'a']++;
                count++;
            }
            left[i] = count;
        }
        Arrays.fill(alpha, 0);
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (alpha[c[i] - 'a'] == 0) {
                alpha[c[i] - 'a']++;
                count++;
            }

            right[i] = count;
        }
        count = 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1])
                count++;
        }
        return count;
    }
}
