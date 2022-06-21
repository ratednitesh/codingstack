package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/is-subsequence/
 ****************************/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        // if s contains any character that do not exist in t return false.
        // approach 1: find all subsequence and compare with s.
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++i == m)
                    return true;
            }
        }
        return false;
    }
}
