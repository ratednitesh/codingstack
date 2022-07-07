package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
*https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/
****************************/
public class MaximumConsecutiveFloorsWithoutSpecialFloor {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length, res = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; i++) {
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }
        return res;
    }
}
