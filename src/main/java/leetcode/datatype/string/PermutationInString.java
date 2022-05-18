package main.java.leetcode.datatype.string;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/permutation-in-string/
 ****************************/
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 == 0) return true;
        if (len1 > len2) return false;
        int[] charCountS1 = new int[26];
        int[] charCountS2 = new int[26];
        // Complexity : O(S1)
        for (int i = 0; i < len1; i++) {
            charCountS1[s1.charAt(i) - 'a']++;
            charCountS2[s2.charAt(i) - 'a']++;
        }
        // Complexity : O(26)
        if (Arrays.equals(charCountS1, charCountS2))
            return true;
        //  complexity : O(S2)
        for (int i = 0, j = len1; j < len2; j++, i++) {
            charCountS2[s2.charAt(i) - 'a']--;
            charCountS2[s2.charAt(j) - 'a']++;
            if (Arrays.equals(charCountS1, charCountS2)) // Complexity : O(26)
                return true;
        }
        return false;
    }
}
