package main.java.leetcode.datastructure.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/01-matrix/
 ****************************/
public class DistanceOfNearestZeroBinaryMatrix {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 1, 1}, {1, 0, 0, 0, 1}};
        updateMatrixBFS(arr);
        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
    }

    // Using two way iteration - DP : Optimal
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if (m == 1 && n == 1)
            return mat;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    continue;
                mat[i][j] = m + n;
                if (i > 0)
                    mat[i][j] = Math.min(mat[i - 1][j] + 1, mat[i][j]);
                if (j > 0)
                    mat[i][j] = Math.min(mat[i][j - 1] + 1, mat[i][j]);
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0)
                    continue;
                if (i < m - 1)
                    mat[i][j] = Math.min(mat[i + 1][j] + 1, mat[i][j]);
                if (j < n - 1)
                    mat[i][j] = Math.min(mat[i][j + 1] + 1, mat[i][j]);
            }
        }
        return mat;
    }

    // Using BFS
    public static int[][] updateMatrixBFS(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] isVisited = new boolean[m][n];
        if (m == 1 && n == 1)
            return mat;
        int[][] helperGrid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                for (int[] h : helperGrid) {
                    int x = index[0] + h[0];
                    int y = index[1] + h[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y])
                        continue;
                    isVisited[x][y] = true;
                    mat[x][y] = step;
                    queue.add(new int[]{x, y});
                }
            }
            step++;
        }
        return mat;
    }


}
