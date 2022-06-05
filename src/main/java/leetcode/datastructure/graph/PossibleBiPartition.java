package main.java.leetcode.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/possible-bipartition/
 ****************************/
public class PossibleBiPartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                if (group[i] == g)
                    return false;
                if (group[i] == 0 && dfs(graph, group, i, -g))
                    return false;
            }
        }
        return true;
    }

    // O(V + E) ||  1 - color[vertex] formula
    public boolean possibleBiPartition(int N, int[][] dislikes) {
        boolean[][] graph = new boolean[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = true;
            graph[d[1] - 1][d[0] - 1] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] colors = new int[N];
        Arrays.fill(colors, -1);
        for (int i = 0; i < N; i++) {
            if (colors[i] != -1)
                continue;
            colors[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int j = 0; j < N; j++) {
                    if (graph[current][j]) {
                        if (colors[j] == -1) {
                            colors[j] = 1 - colors[current];
                            queue.offer(j);
                        } else if (colors[j] == colors[current])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}