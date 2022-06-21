package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 ****************************/
public class CountSquareSubMatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        System.out.println(countSquares(mat));
    }

    public static int countSquares(int[][] matrix) {
        // https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
        if (matrix.length == 1 && matrix[0].length == 1)
            return matrix[0][0];
        int result = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                result += matrix[i][j];
            }
        }
        return result;
    }

}
