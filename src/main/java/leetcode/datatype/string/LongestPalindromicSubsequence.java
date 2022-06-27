package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 ****************************/
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    /* https://www.youtube.com/watch?v=yZWmS6CXbQc
     *https://www.techiedelight.com/longest-palindromic-subsequence-using-dynamic-programming/#:~:text=Longest%20Palindromic%20Subsequence%20using%20Dynamic%20Programming,-The%20Longest%20Palindromic&text=Unlike%20substrings%2C%20subsequences%20are%20not,positions%20within%20the%20original%20sequences.&text=This%20yields%20the%20below%20recursive,Subsequence%20of%20a%20sequence%20X.
    General Idea
                |	1  									(if i == j)
    LPS[i..j] = |	LPS[i+1...j-1]+2					(if S[i] == S[j])
                |	Max(LPS[i+1...j],LPS[i...j-1])		(if S[i] != S[j])

    */

    /*******************
     * Approach 1: TLE: using recursion
     *
     * Time Complexity : O(2^(n)
     *
     * Space Complexity : O(n)
     **********************************/
    public int longestPalindromeSubseqApproach1(String s) {
        return longestPalindromeSubseqApproach1Helper(0, s.length() - 1, s);
    }

    int longestPalindromeSubseqApproach1Helper(int l, int r, String s) {
        if (l == r)
            return 1;
        if (l > r)
            return 0; // happens after "aa"
        return s.charAt(l) == s.charAt(r) ? 2 + longestPalindromeSubseqApproach1Helper(l + 1, r - 1, s)
                : Math.max(longestPalindromeSubseqApproach1Helper(l + 1, r, s),
                longestPalindromeSubseqApproach1Helper(l, r - 1, s));
    }


    /*******************
     * Approach 2: Top Down Memoization
     *
     * Time Complexity : O(n * n)
     *
     * Space Complexity : O(n * n)
     **********************************/
    public int longestPalindromeSubseqApproach2(String s) {
        return longestPalindromeSubseqApproach2Helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    private int longestPalindromeSubseqApproach2Helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)
            return 0;
        if (i == j)
            return 1;

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = longestPalindromeSubseqApproach2Helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(longestPalindromeSubseqApproach2Helper(s, i + 1, j, memo),
                    longestPalindromeSubseqApproach2Helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }

    // TODO: Bottom up approaches below

    /*******************
     * Approach 3: Bottom Up Tabulation
     *
     * Time Complexity : O(n * n)
     *
     * Space Complexity : O(n * n)
     **********************************/
    public int longestPalindromeSubseqApproach3(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }


    /*******************
     * Approach 4: Bottom Up Tabulation with space optimization
     *
     * Time Complexity : O(n * n)
     *
     * Space Complexity : O(n)
     **********************************/
// Credit: https://leetcode.com/problems/longest-palindromic-subsequence/discuss/194748/Java-DP-From-O(n2)-to-O(n)-space-with-only-one-array
/* 	Very tricky DIfficult to understand
	dp[i][j] only depends on dp[i+1][j-1](down-left), dp[i+1][j](down) and dp[i][j-1](left).
	So if we reduce dp[n][m] to dp[m], that means, for dp[j], its down is itself, its left is dp[j-1].
	Its down-left is a little tricky.
	As its down-left dp[i+1][j-1] is now dp[j-1], so we need to preserve it before updating to dp[j-1.
*/
    public static int longestPalindromeSubseq(String s) {
        int[] dp = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < s.length(); j++) {
                int tmp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = tmp;
            }
        }

        return dp[s.length() - 1];
    }


}
