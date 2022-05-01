package main.java.algo.string;

/***************************
 * https://leetcode.com/problems/valid-palindrome/
 *
 ****************************/
public class PalindromePhrase {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("fdggh"));
    }

    public static boolean isPalindrome(String s) {
        int i = s.length() - 1;
        int j = 0;
        while (i > j) {
            char c = s.charAt(i);
            char d = s.charAt(j);
            if (!Character.isLetterOrDigit(c))
                i--;
            else if (!Character.isLetterOrDigit(d))
                j++;
            else {
                if (Character.toLowerCase(c) != Character.toLowerCase(d))
                    return false;
                i--;
                j++;
            }
        }
        return true;
    }
}
