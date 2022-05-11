package main.java.leetcode.unordered.medium;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 ****************************/
public class LetterCombinationOfPhoneNumbers {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        String[] phoneMap = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (char c : digits.toCharArray()) {
            String s = phoneMap[c - '0' - 1];
            List<String> temp = new ArrayList<>();
            for (char c1 : s.toCharArray()) {
                for (String x : result) {
                    temp.add(x + c1);
                }
            }
            result = temp;
        }
        return result;
    }
}
