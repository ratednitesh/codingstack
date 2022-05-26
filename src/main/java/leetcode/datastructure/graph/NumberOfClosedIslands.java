package main.java.leetcode.datastructure.graph;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/number-of-closed-islands/
 ****************************/
public class NumberOfClosedIslands {
    public static void main(String[] args) {
        int[][] arr =
                {{0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}};
        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
        System.out.println(closedIsland(arr));
        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
    }

    public static int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // edge cases 1x1
        if (m == 1 && n == 1) {
            return 0;
        }
        int numberOfIslands = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {

                    if (traverse(grid, m, n, i, j)) {
                        numberOfIslands++;
                    }
                }
            }
        }
        return numberOfIslands;
    }

    public static boolean traverse(int[][] grid, int m, int n, int i, int j) {
        if (grid[i][j] == 1)
            return true;
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1)
            return false;
        grid[i][j] = 1;
        boolean res = true;
        res &= traverse(grid, m, n, i + 1, j);
        res &= traverse(grid, m, n, i - 1, j);
        res &= traverse(grid, m, n, i, j + 1);
        res &= traverse(grid, m, n, i, j - 1);
        return res;
    }
}
