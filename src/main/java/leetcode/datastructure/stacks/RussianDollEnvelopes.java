package main.java.leetcode.datastructure.stacks;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/russian-doll-envelopes/
 ****************************/
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        // edge case
        if (envelopes.length == 1)
            return 1;
        //sort by width ,
        // if width same sort by height in descending order. (to get rid of false positives when Applying LIS)
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            else
                return o1[0] - o2[0];
        });
        // Now find longest increasing subsequence by height.
        int[] dp = new int[envelopes.length];
        int size = 0;
        for (int[] e : envelopes) {
            int start = 0, end = size;
            while (start != end) {
                int mid = start + (end - start) / 2;
                if (dp[mid] < e[1])
                    start = mid + 1;
                else
                    end = mid;
            }
            dp[start] = e[1];
            if (start == size) size++;
        }
        return size;
    }
}
