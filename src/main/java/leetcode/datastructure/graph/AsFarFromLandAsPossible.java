package main.java.leetcode.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 ****************************/
public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        System.out.println(maxDistanceDP(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }

    // Approach 1: using BFS
    public static int maxDistance(int[][] grid) {
        int[][] helperGrid = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int depth = -1, m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.size() == m * n) return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] indexes = queue.poll();
                for (int[] g : helperGrid) {
                    int x = indexes[0] + g[0];
                    int y = indexes[1] + g[1];
                    if (x < m && y < n && x >= 0 && y >= 0 && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.offer(new int[]{indexes[0] + g[0], indexes[1] + g[1]});
                    }
                }
            }
            depth++;
        }
        return depth;
    }

    // Approach 2: using two way iteration
    public static int maxDistanceDP(int[][] grid) {
        int maxDepth = -1;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = m + n;
                    if (i > 0)
                        grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                    if (j > 0)
                        grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    if (i < m - 1)
                        grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                    if (j < n - 1)
                        grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                    maxDepth = Math.max(maxDepth, grid[i][j]);
                }
            }
        }

        return maxDepth == m + n ? -1 : maxDepth;
    }
}
