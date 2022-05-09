package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/find-the-difference/
 ****************************/
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifferenceXOR("abcad", "dcaeba"));
    }

    public static char findTheDifference(String s, String t) {
        // Approach 1: using HashMap
        // Approach 2: using 26 char array
        // Approach 3: sorting the two strings
        // Approach 4: XOR everything
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--chars[c - 'a'] < 0)
                return c;
        }
        return 'a';
    }

    public static char findTheDifferenceXOR(String s, String t) {
        char xor = 0;
        for (char c : s.toCharArray()) {
            xor ^= c;
        }
        for (char c : t.toCharArray()) {
            xor ^= c;
        }
        return xor;
    }
}
