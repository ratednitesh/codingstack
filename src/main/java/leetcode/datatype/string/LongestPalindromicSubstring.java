package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/longest-palindromic-substring/
 ****************************/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababccb"));
    }

    // Approach 1: For each character try to extend the string as long as it is still palindrome.
    // When extending, consider both odd and even cases.
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        int[] maxLenStart = {0, -1};
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(maxLenStart, s, length, i, i + 1); // for even
            extendPalindrome(maxLenStart, s, length, i, i);
        }
        return s.substring(maxLenStart[1], maxLenStart[1] + maxLenStart[0]);
    }

    private static void extendPalindrome(int[] maxLenStart, String s, int length, int i, int j) {

        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLenStart[0] < j - i - 1) {
            maxLenStart[0] = j - i - 1;
            maxLenStart[1] = i + 1;
        }

    }

    // Using DP
    public static String longestPalindromeDP(String s) {
        if (s.length() < 2) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                boolean charEq = s.charAt(i) == s.charAt(j);
                if (i == j)
                    dp[i][j] = true;
                else if (i == j + 1)
                    dp[i][j] = charEq;
                else if (charEq && dp[i - 1][j + 1]) { //string is palindrome if s(i) == s(j) and substring s(j + 1, i - 1) is palindrome
                    dp[i][j] = true;
                }
                if (dp[i][j] && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
