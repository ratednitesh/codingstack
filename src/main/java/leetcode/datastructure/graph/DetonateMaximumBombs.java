package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/detonate-the-maximum-bombs/
 ****************************/
public class DetonateMaximumBombs {
    public static void main(String[] args) {
        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        System.out.println(maximumDetonation(bombs));
    }

    public static int maximumDetonation(int[][] bombs) {
        int l = bombs.length;
        if (l == 1) return 1;
        int max = 0;
        for (int i = 0; i < l; i++) {
            max = Math.max(max, dfs(bombs, new boolean[bombs.length], i));
        }
        return max;
    }

    private static int dfs(int[][] bombs, boolean[] isVisited, int start) {
        isVisited[start] = true;
        int count = 1;
        for (int i = 0; i < bombs.length; i++) {
            if (!isVisited[i] && isOverlappingCircles(bombs[start], bombs[i])) {
                count += dfs(bombs, isVisited, i);
            }
        }
        return count;
    }


    public static boolean isOverlappingCircles(int[] bomb1, int[] bomb2) {
        double distance = Math.pow(bomb1[0] - bomb2[0], 2) + Math.pow(bomb1[1] - bomb2[1], 2);
        double radius = bomb1[2];
        return radius * radius >= distance;
    }
}
