package main.java.leetcode.operations.dynamicProgramming;

import java.util.List;

/***************************
 * https://leetcode.com/problems/triangle/
 ****************************/
public class Triangle {

    // Approach 1: DP with O(NxN) space
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // opt[i][j] is the path sum start from one node of bottom layer to node (i,j)
        int[][] opt = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                opt[i][j] = Math.min(opt[i + 1][j], opt[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return opt[0][0];
    }

    // Approach 2: DP with O(N) space
    public int minimumTotalOpt(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
