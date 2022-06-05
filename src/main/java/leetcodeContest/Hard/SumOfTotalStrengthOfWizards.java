package main.java.leetcodeContest.Hard;

import java.util.Arrays;

/***************************
 * https://leetcode.com/contest/weekly-contest-294/problems/sum-of-total-strength-of-wizards/
 ****************************/
public class SumOfTotalStrengthOfWizards {
    public static void main(String[] args) {
        System.out.println(totalStrengthOpt(new int[]{1, 3, 1, 2}));
    }

    // time limit exceeded solution
    public static int totalStrength(int[] strength) {
        int M = 1000000007;
        int n = strength.length;
        if (n == 1)
            return (strength[0] * strength[0]) % M;

        int total = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            total += min * sum % M;
            for (int j = i; j < n; j++) {
                min = Math.min(strength[j], min);
                sum = sum % M + strength[j];
                System.out.println(sum);
                total = total % M + (min % M * sum % M) % M;
            }
        }

        return total;
    }

    // another solution -time limit exceeded
    public static int totalStrengthOpt(int[] strength) {
        int M = 1000000007;
        int n = strength.length;
        if (n == 1)
            return (strength[0] * strength[0]) % M;
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[] sum = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {


                min[j] = Math.min(min[j], strength[i + j]);
                sum[j] = (sum[j] % M + strength[i + j] % M) % M;
                System.out.println(sum[j] * min[j]);
//                total += min[j] * sum[j];
                total = ((total % M) + ((sum[j] % M) * (min[j] % M)) % M) % M;
            }
        }
        return total;
    }
    // TODO: work on ideal solution
}
