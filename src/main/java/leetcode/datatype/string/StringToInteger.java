package main.java.leetcode.datatype.string;

/***************************
 *https://leetcode.com/problems/string-to-integer-atoi/
 *Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 ****************************/
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("      -4193 with words"));
    }

    public static int myAtoi(String s) {
        int len = s.length();
        if (len == 0)
            return 0;

        int i = 0;
        // skipping white space
        while (i < len && s.charAt(i) == ' ') {
            ++i;
        }

        // handling signs
        boolean isNegative = false;
        if (i < len) {
            if (s.charAt(i) == '-') {
                isNegative = true;
                ++i;
            } else if (s.charAt(i) == '+')
                ++i;
        }
        int result = 0;

        // iterate until non digit character
        while (i < len && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            int digit = s.charAt(i) - '0';
            // handling integer overflow
            if (result > Integer.MAX_VALUE / 10 || result * 10 > Integer.MAX_VALUE - digit)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + digit;
            i++;
        }
        return isNegative ? -result : result;
    }


}
