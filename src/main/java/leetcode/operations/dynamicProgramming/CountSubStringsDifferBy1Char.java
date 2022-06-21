package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 ****************************/
public class CountSubStringsDifferBy1Char {
    public static void main(String[] args) {

    }

    // O(m*n*min(m,n)) ~ O(n^3)
    public int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int miss = 0;
                for (int pos = 0; pos < s.length() - i && pos < t.length() - j; pos++) {
                    if (s.charAt(i + pos) != t.charAt(j + pos) && ++miss > 1)
                        break;
                    res += miss;
                }
            }
        }
        return res;
    }

    public int countSubstringsOther(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                result += count(s, t, i, j);
            }
        }
        return result;
    }

    private int count(String s, String t, int i, int j) {
        return s.charAt(i) == t.charAt(j) ? 0 : next(s, t, i + 1, j + 1) * prev(s, t, i - 1, j - 1);
    }

    private int prev(String s, String t, int i, int j) {
        int res = 1;
        while (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
            i--;
            j--;
            res++;
        }
        return res;
    }

    private int next(String s, String t, int i, int j) {
        int res = 1;
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
            res++;
        }
        return res;
    }

    // Approach using DP
    public int countSubstringsOtherDP(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dpLeft = new int[m + 1][n + 1];
        int[][] dpRight = new int[m + 1][n + 1];
        int result = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dpLeft[i][j] = 1 + dpLeft[i - 1][j - 1];
            }
        }
        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dpRight[i - 1][j - 1] = 1 + dpRight[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) != t.charAt(j))
                    result += (dpLeft[i][j] + 1) * (dpRight[i + 1][j + 1] + 1);
            }
        }
        return result;
    }

    // TODO: https://leetcode.com/problems/count-substrings-that-differ-by-one-character/discuss/1182847/Java-clean-O(MN)-time-O(1)-space-Dynamic-Programming-Solution-oror-with-comments
}
