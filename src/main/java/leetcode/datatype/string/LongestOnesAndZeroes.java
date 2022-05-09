package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 ****************************/
public class LongestOnesAndZeroes {
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1011"));
    }

    public static boolean checkZeroOnesEnhanced(String s) {
        if (s.length() == 1) return s.charAt(0) == '1';
        int maxZeros = 0, maxOnes = 0;
        for (int i = 0, zeros = 0, ones = 0; i < s.length(); i++)
            if (s.charAt(i) == '0') {
                maxZeros = Math.max(maxZeros, ++zeros);
                ones = 0;
            } else {
                maxOnes = Math.max(maxOnes, ++ones);
                zeros = 0;
            }
        return maxOnes > maxZeros;
    }

    public static boolean checkZeroOnes(String s) {
        if (s.length() == 1) return s.charAt(0) == '1';
        int maxZero = 0, maxOnes = 0;
        for (int i = 1, count = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (s.charAt(i) == '1')
                    maxOnes = Math.max(maxOnes, ++count);
                else
                    maxZero = Math.max(maxZero, ++count);
            } else {
                count = 1;
            }
        }
        return maxOnes > maxZero;
    }
}
