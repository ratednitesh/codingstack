package main.java.leetcode.unordered.easy;

import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/ransom-note/
 ****************************/
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("abca", "abc"));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() == 0) return true;
        else if (magazine.length() == 0) return false;
        if (ransomNote.length() > magazine.length()) return false;
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--arr[c - 'a'] == 0)
                return false;
        }
        return true;
    }

    public static boolean canConstructHM(String ransomNote, String magazine) {
        // approach 1:
        // store magazine to HashMap  with key = chars, value = count
        // iterate ransomNote and update map on each iteration if char is used from magazine

        // approach 3:
        // both vars consists of lowerCase english letters - 26 possibilities
        // form 26 elements array using ransom
        // iterate over ransom for each char index update count = count+1;
        // iterate over magazine
        //
        // time : O(N) and space: constant

        if (ransomNote.length() == 0) return true;
        else if (magazine.length() == 0) return false;

        if (ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (hm.containsKey(c)) {
                if (hm.get(c) == 0)
                    return false;
                hm.put(c, hm.get(c) - 1);
            } else
                return false;
        }
        return true;
    }
}
