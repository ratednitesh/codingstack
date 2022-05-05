package main.java.leetcode.datatype.string;

import java.util.HashMap;
import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 ****************************/
public class LongestSubstringNoRepetition {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring2("aab"));
    }

    // using HashSet
    //The idea is use a hash set to track the longest substring without repeating characters so far, use a fast pointer j to see if character j is in the hash set or not, if not, great, add it to the hash set, move j forward and update the max length, otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int j = 0, max = 0, i = 0;
        while (j < s.length()) {
            if (hs.add(s.charAt(j))) {
                max = Math.max(max, hs.size());
                j++;
            } else {
                hs.remove(s.charAt(i++));
            }
        }

        return max;
    }

    // using sliding window
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null)
            throw new IllegalStateException("Input string is null");
        int len = s.length();
        if (len == 1)
            return len;
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < len; end++) {
            if (hm.containsKey(s.charAt(end)))
                start = Math.max(start, hm.get(s.charAt(end)) + 1);
            hm.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    // using 256 array
    public int lengthOfLongestSubstring3(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}
