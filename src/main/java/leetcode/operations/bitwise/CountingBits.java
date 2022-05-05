package main.java.leetcode.operations.bitwise;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/counting-bits/
 ****************************/
public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i >> 1] + (i & 1);
//    Alternate equivalent code:  f[i] = f[i / 2] + (i % 2);
        }
        return f;
    }
}
