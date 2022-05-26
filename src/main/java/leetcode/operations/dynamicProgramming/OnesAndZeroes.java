package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/ones-and-zeroes/
 ****************************/
public class OnesAndZeroes {
    public static void main(String[] args) {
        String[] arr = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxFormDP(arr, 5, 3));
    }


    // Approach 2: Recursive Solution | Solution works but time limit exceeded.
    public static int findMaxFormRecur(String[] strs, int m, int n) {
        return recur(strs, m, n, 0);
    }

    public static int recur(String[] strs, int m, int n, int start) {
        if (start == strs.length)
            return 0;
        if (m == 0 && n == 0)
            return 0;
        if (m < 0 || n < 0)
            return 0;
        String s = strs[start];
        int ones = 0;
        int zeroes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;
            else
                zeroes++;
        }
        if (zeroes <= m && ones <= n)
            return Math.max(1 + recur(strs, m - zeroes, n - ones, start + 1), recur(strs, m, n, start + 1));
        else
            return recur(strs, m, n, start + 1);
    }

    // Approach 2: DP solution
    public static int findMaxFormDP(String[] strs, int m, int n) {
        // Why DP will help? Consider one String at a time and find the max number of Strings to satisfy m= 0->m and n = 0->n
        // This means we will have a DP array of [m+1][n+1] .. the final answer be in dp[m][n]
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) { // iterate over each String consider one at a time
            int one = 0;
            int zero = 0;
            for (char c : str.toCharArray()) {
                if (c == '1')
                    one++;
                else
                    zero++;
            }
            // till this point we have number of ones and zeroes.
            // if ones or zeroes are greater than m and n resp. the dp array won't be impacted.
            // in fact for each String the dp array will only be impacted dp[zeroes][ones] to dp[m][n].
            // so iterating over this part of the dp array.
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    // Now, we are starting from last of the array and we will go back updating each cell.
                    // why going back and not forward.. each cell contains max length for that m and n pair.
                    // ok what are possibility of max lengths-
                    // a. the current length would continue to be so if new length is lower than current max length.
                    // b. new length will become current length, where new length = 1+ dp[i-zero][j-one].
                    // why? because.. if current string was not considered, dp[i-zero][j-one] would have our answer for
                    // m= i-zero and n= j-one. in other words, this cell will hold max length for m= i-zero and n= j-one
                    // so consider current string to achieve m and n we can consider this cell and add 1 for current string
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    // The logic for going backwards or Top- Down is coz if we go bottom up, the current String would impact the smaller cells
                    // and as explained above higher cells are computed based on smaller cells. if we update smaller cells first we will lose
                    // the value for smaller cells up till last string.
                }
            }
        }
        return dp[m][n];
    }
}
