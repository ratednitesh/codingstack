package main.java.leetcode.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***************************
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 ****************************/
public class FindIfPathExists {
    public static void main(String[] args) {

        int[][] edges = {{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {7, 4}, {1, 3}, {3, 5}, {6, 5}};
        System.out.println(validPath(10, edges, 7, 5));
    }

    // Approach 1: Memory Exceeded
    public static boolean validPathME(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        boolean[][] graph = new boolean[n][n];
        // Prepare Graph
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        // Check for direct connection
        if (graph[source][destination])
            return true;
        // Check for DFS
        boolean[] isVisited = new boolean[n];
        return dfsME(graph, isVisited, source, destination);
    }

    public static boolean dfsME(boolean[][] graph, boolean[] isVisited, int start, int end) {
        if (isVisited[start])
            return false;
        isVisited[start] = true;
        for (int i = 0; i < graph[0].length; i++) {
            if (!isVisited[i] && start != i && graph[start][i]) {
                if (i == end || dfsME(graph, isVisited, i, end))
                    return true;
            }
        }
        return false;
    }

    // Approach 2 : Using MAPS
    public static boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        //construct graph, add bidirectional vertex
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //start dfs from start point
        return dfs(graph, visited, start, end);
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start, int end) {
        if (visited[start]) return false;
        visited[start] = true;
        //when we found and neighbour which is equal to end point inside the recursion, voooleeey! break and return the true
        for (int nei : graph.get(start)) {
            if (!visited[nei] && start != nei) {
                if (nei == end || dfs(graph, visited, nei, end))
                    return true;
            }
        }
        return false;
    }
    // TODO: DisjointSetUnion https://leetcode.com/problems/find-if-path-exists-in-graph/discuss/1406774/Java-4-solutions-union-find-9ms-Union-by-Rank-14-ms-DFS-88-ms-BFS-90-ms
}
