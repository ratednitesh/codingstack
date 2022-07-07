package main.java.leetcode.datatype.numbers;
/***************************
* https://leetcode.com/problems/ugly-number-ii/
****************************/
public class UglyNumbers2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int num = Math.min(factor2, Math.min(factor3, factor5));
            dp[i] = num;
            if (num == factor2) {
                factor2 = 2 * dp[++index2];
            }
            if (num == factor3) {
                factor3 = 3 * dp[++index3];
            }
            if (num == factor5) {
                factor5 = 5 * dp[++index5];
            }
        }
        return dp[n - 1];
    }
}
