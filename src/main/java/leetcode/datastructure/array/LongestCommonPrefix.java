package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/longest-common-prefix/
 ****************************/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"a", "ab", "abc"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        if (strs == null || strs.length == 0) return "";
        StringBuilder commonPrefix = new StringBuilder();
        while (true) {
            char prev = 0;
            for (String str : strs) {
                if (i == str.length() || (prev != str.charAt(i) && prev != 0))
                    return commonPrefix.toString();
                if (prev == 0)
                    prev = str.charAt(i);
            }
            commonPrefix.append(prev);
            i++;
        }
    }
}
