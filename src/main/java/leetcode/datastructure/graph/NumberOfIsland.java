package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/number-of-islands/
 ****************************/
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        // edge cases 1x1
        if (m == 1 && n == 1) {
            return grid[0][0] - '0';
        }
        int numberOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public static void traverse(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        traverse(grid, i + 1, j);
        traverse(grid, i - 1, j);
        traverse(grid, i, j + 1);
        traverse(grid, i, j - 1);
    }
}
