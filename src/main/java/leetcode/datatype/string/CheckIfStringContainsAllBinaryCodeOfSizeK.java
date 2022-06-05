package main.java.leetcode.datatype.string;

import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 ****************************/
public class CheckIfStringContainsAllBinaryCodeOfSizeK {
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
    }

    public static boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < s.length() - k; i++) {
            hs.add(Integer.parseInt(s.substring(i, i + k)));
        }
        return hs.size() == (int) Math.pow(2, k);
    }
}
