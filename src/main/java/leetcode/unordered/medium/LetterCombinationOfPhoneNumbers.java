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

    // backtracking
    public List<String> letterCombinationsBT(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder combination = new StringBuilder();
        backtrack(result, mapping, combination, digits, 0);
        return result;
    }

    private void backtrack(List<String> result, String[] mapping, StringBuilder combination, String digits, int index) {


        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            String letters = mapping[digits.charAt(index) - '0'];
            for (char letter : letters.toCharArray()) {
                combination.append(letter);
                backtrack(result, mapping, combination, digits, index + 1);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
