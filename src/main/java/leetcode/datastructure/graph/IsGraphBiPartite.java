package main.java.leetcode.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 * https://leetcode.com/problems/is-graph-bipartite/
 ****************************/
public class IsGraphBiPartite {

    public boolean isBipartite(int[][] graph) {
        boolean[][] g = new boolean[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int gr : graph[i])
                g[i][gr] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != -1)
                continue;
            colors[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int j = 0; j < graph.length; j++) {
                    if (g[current][j]) {
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
