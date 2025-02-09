package main.java.leetcode.unordered.medium;

/***************************
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 ****************************/

public class KthSmallest {
    public static void main(String[] args) {
        int[][] input = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(input, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int start = matrix[0][0], end = matrix[m - 1][n - 1], result = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (countLessOrEqual(matrix, mid) < k)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    static int countLessOrEqual(int[][] matrix, int x) {
        int count = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = matrix[0].length - 1; c >= 0; c--) {
                if (matrix[r][c] <= x) {
                    count += c + 1;
                    break;
                }
            }
        }
        return count;
    }
}
