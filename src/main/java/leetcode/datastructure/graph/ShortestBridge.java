package main.java.leetcode.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/shortest-bridge/
 ****************************/
public class ShortestBridge {
    public static void main(String[] args) {
        System.out.println(shortestBridge(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    public static int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean breakFlag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, m, n, i, j, queue);
                    breakFlag = true;
                    break;
                }
            }
            if (breakFlag) break;
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] indexes = queue.poll();
                for (int[] h : helperGrid) {
                    int x = indexes[0] + h[0];
                    int y = indexes[1] + h[1];

                    if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == -1)
                        continue;
                    if (grid[x][y] == 1)
                        return depth;
                    grid[x][y] = -1;
                    queue.offer(new int[]{x, y});
                }
            }
            depth++;
        }
        return -1;
    }

    private static void dfs(int[][] grid, int m, int n, int i, int j, Queue queue) {
        if (i == m || j == n || i < 0 || j < 0 || grid[i][j] == -1 || grid[i][j] == 0)
            return;
        grid[i][j] = -1;
        queue.offer(new int[]{i, j});
        for (int[] h : helperGrid)
            dfs(grid, m, n, i + h[0], j + h[1], queue);

    }

    static int[][] helperGrid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
}
