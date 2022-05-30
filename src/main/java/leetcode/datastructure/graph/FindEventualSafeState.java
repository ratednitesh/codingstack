package main.java.leetcode.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/find-eventual-safe-states/
 *
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
 *
 * A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node.
 *
 * Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 ****************************/
public class FindEventualSafeState {
    public static void main(String[] args) {

    }

    // States: 0= Not visited yet 1= Safe State -1 = Unsafe State
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (dfs(graph, state, i))
                res.add(i);
        return res;
    }

    private boolean dfs(int[][] graph, int[] state, int i) {
        if (state[i] != 0) return state[i] == 1;
        state[i] = -1; // consider it unsafe by default.
        for (int n : graph[i]) {
            if (!dfs(graph, state, n))
                return false;
        }
        state[i] = 1; // if reached this step means it is safe
        return true;
    }
}
