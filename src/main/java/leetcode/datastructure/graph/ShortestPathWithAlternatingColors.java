package main.java.leetcode.datastructure.graph;

import java.util.*;

/***************************
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 ****************************/
public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestAlternatingPaths(3, new int[][]{{0, 1}}, new int[][]{{2, 1}})));
    }

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // Two sets one for blu and another for red
        Set<Integer>[][] graph = new HashSet[2][n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        // red edges in 0 - col
        for (int[] re : redEdges) {
            graph[0][re[0]].add(re[1]);
        }
        // blu edges in 1 - col
        for (int[] blu : blueEdges) {
            graph[1][blu[0]].add(blu[1]);
        }
        int[][] res = new int[2][n];
        // Zero edge is always accessible to itself - leave it as 0
        for (int i = 1; i < n; i++) {
            res[0][i] = Integer.MAX_VALUE; // can use 2*n as well
            res[1][i] = Integer.MAX_VALUE;
        }
        // Q entries are vert with a color (up to that point)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // either with red
        q.offer(new int[]{0, 1}); // or with blue
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int vert = cur[0];
            int colr = cur[1];
            // No need to keep track of level up to now
            // only need to keep what color - and the length
            // is automatically derived from previous node
            for (int nxt : graph[1 - colr][vert]) {
                if (res[1 - colr][nxt] == Integer.MAX_VALUE) {
                    res[1 - colr][nxt] = 1 + res[colr][vert];
                    q.offer(new int[]{nxt, 1 - colr});
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = Math.min(res[0][i], res[1][i]);
            ans[i] = (t == Integer.MAX_VALUE) ? -1 : t;
        }
        return ans;
    }
}
