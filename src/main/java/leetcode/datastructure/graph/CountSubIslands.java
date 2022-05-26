package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/count-sub-islands/
 ****************************/
public class CountSubIslands {
    public static void main(String[] args) {
        System.out.println(countSubIslands(new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}}, new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    result += dfs(grid2, grid1, m, n, i, j);
                }
            }
        }
        return result;
    }

    static int[][] helperGrid = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    private static int dfs(int[][] grid2, int[][] grid1, int m, int n, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0 || grid2[i][j] == 0)
            return 1;
        grid2[i][j] = 0;
        int result = 1;
        for (int[] g : helperGrid) {
            result &= dfs(grid2, grid1, m, n, i + g[0], j + g[1]);
        }
        return result & grid1[i][j];
    }
}
