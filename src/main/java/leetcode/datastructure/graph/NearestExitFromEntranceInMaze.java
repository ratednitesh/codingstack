package main.java.leetcode.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 ****************************/
public class NearestExitFromEntranceInMaze {
    public static void main(String[] args) {
        System.out.println(nearestExit(new char[][]{{'.', '+'}}, new int[]{0, 0}));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        if (m == 1 && n == 1)
            return -1;
        int[][] helperGrid = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+';
        queue.offer(new int[]{entrance[0], entrance[1]});
        int depth = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] indexes = queue.poll();
                for (int[] h : helperGrid) {
                    int x = indexes[0] + h[0];
                    int y = indexes[1] + h[1];
                    if (x == m || y == n || x < 0 || y < 0) {
                        if (depth != 0)
                            return depth;
                        continue;
                    }
                    if (maze[x][y] != '+') {
                        maze[x][y] = '+';
                        queue.offer(new int[]{x, y});
                    }
                }
            }

        }
        return -1;
    }
}
