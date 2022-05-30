package main.java.leetcode.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 ****************************/
public class MakeNetworkConnected {
    public static void main(String[] args) {
        System.out.println(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));
    }

    public static int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if (edges < n - 1)
            return -1;
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            list[c[0]].add(c[1]);
            list[c[1]].add(c[0]);
        }
        boolean[] visited = new boolean[n];
        int numberOfConnectedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(list, visited, i);
                numberOfConnectedComponents++;
            }
        }
        /*
            A. For one component C1, with 'N1' nodes you need at least 'N1-1' edges. redundantEdgesForC1 = edgesC1 - (N1-1);
            Finding redundant nodes total = (edgesC1 + edgesC2... ) - (N1 + N2 ... - numberOfConnectedComponents)
            OR redundantNodesTotal = edges - (n - numberOfConnectedComponents)

            B. To connect 'numberOfConnectedComponents' components, you need at least 'numberOfConnectedComponents-1' edges.

            C. if(redundantNodesTotal >= numberOfConnectedComponents-1) then it is possible by 'numberOfConnectedComponents-1' edges
            to connect all nodes else not!
         */
        int redundantEdges = edges - (n - numberOfConnectedComponents);
        return (redundantEdges >= numberOfConnectedComponents - 1) ? numberOfConnectedComponents - 1 : -1;
    }

    private static void dfs(List<Integer>[] list, boolean[] visited, int i) {
        if (visited[i])
            return;
        visited[i] = true;
        for (int n : list[i]) {
            dfs(list, visited, n);
        }
    }
}
