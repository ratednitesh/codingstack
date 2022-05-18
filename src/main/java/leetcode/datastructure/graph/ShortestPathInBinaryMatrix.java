package main.java.leetcode.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 ****************************/
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    // BFS
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        int path = 0;
        // edge Case:
        if (grid[0][0] == 1 || grid[length - 1][length - 1] == 1)
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[length][length];
        int[][] helperGrid = {{-1, -1}, {-1, 0}, {0, -1}, {-1, 1}, {1, -1}, {1, 0}, {0, 1}, {1, 1}};

        isVisited[0][0] = true;
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            path++;
            for (int i = 0; i < queue.size(); i++) {
                int[] index = queue.poll();
                if (index[0] == length - 1 && index[1] == length - 1)
                    return path;
                for (int[] indexes : helperGrid) {
                    int newXIndex = index[0] + indexes[0];
                    int newYIndex = index[1] + indexes[1];
                    if (newXIndex < 0 || newYIndex < 0 ||
                            newXIndex >= length || newYIndex >= length ||
                            isVisited[newXIndex][newYIndex] || grid[newXIndex][newYIndex] == 1)
                        continue;
                    isVisited[newXIndex][newYIndex] = true;
                    queue.offer(new int[]{newXIndex, newYIndex});
                }
            }
        }

        return -1;
    }


}
