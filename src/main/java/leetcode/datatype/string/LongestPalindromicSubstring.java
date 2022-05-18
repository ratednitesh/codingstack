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
}
