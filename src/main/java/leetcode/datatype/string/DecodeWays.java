package main.java.leetcode.datatype.string;

/***************************
 * https://leetcode.com/problems/decode-ways/
 ****************************/
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("06"));
    }

    // approach 1: dp
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) - '0' == 0 ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            System.out.println(first);
            System.out.println(second);
            if (first > 0)
                dp[i] = dp[i - 1];
            if (second >= 10 && second <= 26)
                dp[i] += i > 1 ? dp[i - 2] : 1;
        }
        return dp[n - 1];
    }

    // approach 2 : dp
    public int numDecodingsDP(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')))
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    // approach 3: dp + constant space
    public int numDecodingsDPOpt(String s) {
        int dp1 = 1, dp2 = 0, n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                dp += dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
