package main.java.leetcode.datastructure.matrix;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/rotting-oranges/
 ****************************/
public class RottingOranges {
    public static void main(String[] args) {
        int[][] arr = {{0}};
        System.out.println(orangesRotting(arr));
    }

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int empty = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    isVisited[i][j] = true;
                } else if (grid[i][j] == 0) {
                    isVisited[i][j] = true;
                    empty++;
                }
            }
        }
        if (queue.size() == m * n || empty == m * n)
            return 0;
        int minutes = -1;
        int[][] helperGrid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] index = queue.poll();
                for (int[] h : helperGrid) {
                    int x = index[0] + h[0], y = index[1] + h[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y])
                        continue;
                    isVisited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            minutes++;
        }
        for (boolean[] b : isVisited) {
            for (boolean b1 : b)
                if (!b1)
                    return -1;
        }
        return minutes;
    }
}
