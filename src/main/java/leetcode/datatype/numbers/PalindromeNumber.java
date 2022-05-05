package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/palindrome-number/
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 ****************************/
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int rev = 0, orig = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == orig;
    }
}
