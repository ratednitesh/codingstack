package main.java.leetcode.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/flood-fill/
 ****************************/
public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);
        for (int[] i : image) {
            System.out.println(Arrays.toString(i));
        }
    }

    // Using BFS
    public static int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int rLength = image.length;
        int cLength = image[0].length;
        if (cLength == 1 && rLength == 1)
            return new int[][]{{newColor}};
        int[][] helperGrid = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] index = queue.poll();
                image[index[0]][index[1]] = newColor;
                for (int[] h : helperGrid) {
                    int newR = index[0] + h[0];
                    int newC = index[1] + h[1];
                    if (newR < 0 || newR >= rLength ||
                            newC < 0 || newC >= cLength ||
                            image[newR][newC] != oldColor)
                        continue;
                    queue.offer(new int[]{newR, newC});
                }
            }
        }
        return image;
    }

    // Using DFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
