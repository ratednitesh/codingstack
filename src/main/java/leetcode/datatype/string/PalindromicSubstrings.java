package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/palindromic-substrings/
 ****************************/
public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        int length = s.length();
        //  logic for each letter try move left or right if it is a palindrome
        for (int i = 0; i < length; i++) {
            result += extendPalindrome(chars, i, i + 1, length);
            result += extendPalindrome(chars, i, i, length);
        }
        return result;
    }

    private static int extendPalindrome(char[] chars, int i, int j, int length) {
        int count = 0;
        while (i >= 0 && j < length && chars[i] == chars[j]) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}
