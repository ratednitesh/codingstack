package main.java.leetcode.datastructure.matrix;

/***************************
 * https://leetcode.com/problems/reshape-the-matrix/
 ****************************/
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat[0].length;
        if (mat.length * n != r * c)
            return mat;
        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++)
            result[i / c][i % c] = mat[i / n][i % n];
        return result;
    }
}
