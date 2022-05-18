package main.java.leetcode.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/critical-connections-in-a-network/
 ****************************/
public class CriticalConnectionsInNetwork {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(0, 1));
        l.add(Arrays.asList(1, 2));
        l.add(Arrays.asList(2, 0));
        l.add(Arrays.asList(1, 3));
        System.out.println(criticalConnections(4, l));
    }

    // Approach: Tarjan's Algorithm
    // Step 1: Setup the Graph
    // Step 2: DFS
    // Step 3: for each Vertex, assign a unique ID to it.
    // Step 4: for each Vertex, after performing DFS, check for all neighbours IDs except the just previous one
    // Step 5: If neighbour ID is lower than current Vertex ID, update current ID with neighbour ID,
    // Step 6: If the neighbour ID is greater than original current vertex ID, the edge between the neighbour and current vertex is a critical edge or a BRIDGE.
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (List<Integer> edge : connections) {
            int vertex1 = edge.get(0);
            int vertex2 = edge.get(1);
            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }
        boolean[] isVisited = new boolean[n];
        int[] ids = new int[n];
        result = new ArrayList<>();
        dfs(graph, isVisited, ids, 0, -1);
        return result;
    }

    static int id = 0;
    static List<List<Integer>> result;

    public static void dfs(List<Integer>[] graph, boolean[] isVisited, int[] ids, int vertex, int previousVertex) {
        isVisited[vertex] = true;
        ids[vertex] = id++;
        int originalCurrentVertexId = ids[vertex];
        for (int neighbouringVertex : graph[vertex]) {
            if (neighbouringVertex == previousVertex)
                continue;
            if (!isVisited[neighbouringVertex]) {
                dfs(graph, isVisited, ids, neighbouringVertex, vertex);
            }
            ids[vertex] = Math.min(ids[vertex], ids[neighbouringVertex]);
            if (originalCurrentVertexId < ids[neighbouringVertex]) {
                result.add(Arrays.asList(vertex, neighbouringVertex));
            }
        }
    }
}
