package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/maximal-network-rank/
 ****************************/
public class MaximalNetworkRank {
    public static void main(String[] args) {

    }

    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        boolean[][] graph = new boolean[n][n];
        int[] roadCount = new int[n];
        for (int[] road : roads) {
            graph[road[0]][road[1]] = true;
            graph[road[1]][road[0]] = true;
            roadCount[road[0]]++;
            roadCount[road[1]]++;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, roadCount[i] + roadCount[j] - (graph[i][j] ? 1 : 0));
            }
        }
        return max;
    }
}
