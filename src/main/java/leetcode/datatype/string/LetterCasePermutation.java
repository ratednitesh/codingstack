package main.java.leetcode.datatype.string;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/letter-case-permutation/
 ****************************/
public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        result.add(s);
        perm(result, 0, chars);
        return result;
    }

    public static void perm(List<String> result, int start, char[] chars) {

        for (int i = start; i < chars.length; i++) {
            // swap chars
            if (swapChars(chars, i)) {
                result.add(String.valueOf(chars));
                perm(result, i + 1, chars);
                // swap char to original position
                swapChars(chars, i);
            }
        }
    }

    public static boolean swapChars(char[] chars, int i) {
        if (chars[i] >= 'a' && chars[i] <= 'z') {
            chars[i] -= 32;
            return true;
        } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
            chars[i] += 32;
            return true;
        }
        return false;
    }
}
