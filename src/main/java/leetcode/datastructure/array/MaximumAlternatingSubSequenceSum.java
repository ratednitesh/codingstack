package main.java.leetcode.datastructure.array;
/***************************
* https://leetcode.com/problems/maximum-alternating-subsequence-sum/
****************************/
public class MaximumAlternatingSubSequenceSum {
    public long maxAlternatingSum(int[] A){
        long res = A[0];
        for (int i = 1; i < A.length; ++i)
            res += Math.max(A[i] - A[i-1], 0);
        return res;
    }
}
