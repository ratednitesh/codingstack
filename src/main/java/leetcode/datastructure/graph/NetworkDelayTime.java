package main.java.leetcode.datastructure.graph;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/network-delay-time/
 ****************************/
public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(arr, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Using Dijkstra's Algorithm
        // Step 1: Setup the graph matrix of nxn such that each cell represents
        // the distance between row node and column node i.e. distance between row -> column
        // If there exist no link between two pairs initialize with infinite
        int[][] graph = new int[n][n];
        for (int[] arr : graph)
            Arrays.fill(arr, Integer.MAX_VALUE);
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        // Step 2: Once the graph is ready, create another array for distance of size n,
        // Initialize with infinite value for each except for the first node for which set the
        // distance as '0'.
        // Also setup another boolean array of size n to mark the node which are visited.
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;
        boolean[] isVisited = new boolean[n];

        // Step 3: Iterate through 0 to n-1.
        // In each iteration,
        for (int i = 0; i < n; i++) {
            // a. First find the index of the starting node or the node closest to start
            //  use the distance array for this. Initially only the kth node (start)
            //  would have 0 as value.
            // Mark the minIndex as 'Visited'.
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < distance.length; j++) {
                if (!isVisited[j] && distance[j] < min) {
                    min = distance[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) continue;
            isVisited[minIndex] = true;
            // b. Once you have the minIndex, iterate over each node j->0 to n-1
            // update the distance array based on the graph value
            // New Distance =
            // Graph Value[minIndex][j]  + current distance till that point i.e distance[minIndex]
            // If New Distance is less than distance[j] update distance[j]
            for (int j = 0; j < n; j++) {
                if (graph[minIndex][j] != Integer.MAX_VALUE) {
                    int newDist = graph[minIndex][j] + distance[minIndex];
                    if (newDist < distance[j])
                        distance[j] = newDist;
                }
            }

        }
        // Step 4: Now the distance array should be ready where each index points to distance
        // or time taken to reach to it
        int result = 0;
        for (int d : distance) {
            if (d == Integer.MAX_VALUE)
                return -1;
            result = Math.max(result, d);
        }
        return result;
    }
}
