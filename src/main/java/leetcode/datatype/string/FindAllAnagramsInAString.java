package main.java.leetcode.datatype.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 ****************************/
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int start = 0, len = p.length();
        int[] chars = new int[26];
        for (char c : p.toCharArray()) {
            chars[c - 'a']++; // abcb
        }
        boolean flag;
        int[] temp;
        char[] ss = s.toCharArray();
        while (start + len - 1 < s.length()) {
            temp = chars.clone();
            for (int i = start; i < start + len; i++) {
                temp[ss[i] - 'a']--;
            }
            start++;
            flag = true;
            for (int i : temp)
                if (i != 0) {
                    flag = false;
                    break;
                }
            if (flag)
                result.add(start - 1);

        }
        return result;
    }

    // Improved Solution // Sliding Window
    public List<Integer> findAnagramsOpt(String s2, String s1) {
        int len2 = s2.length(), len1 = s1.length();
        List<Integer> indices = new ArrayList<>();
        if (len1 > len2) return indices;
        int s1Count[] = new int[26];
        int s2Count[] = new int[26];
        int start = 0;
        int end = 0;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        for (; end < len1; end++) {
            s1Count[s1Char[end] - 'a']++;
            s2Count[s2Char[end] - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) indices.add(start);
        while (end < len2) {
            s2Count[s2Char[start++] - 'a']--;
            s2Count[s2Char[end++] - 'a']++;
            if (Arrays.equals(s1Count, s2Count)) indices.add(start);
        }
        return indices;
    }

}
