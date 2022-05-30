package main.java.leetcode.datastructure.graph;

/***************************
 * https://leetcode.com/problems/number-of-provinces/
 ****************************/
public class NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] isVisited = new boolean[isConnected.length];
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                result++;
                traverse(isConnected, isVisited, i);
            }
        }
        return result;
    }

    private static void traverse(int[][] isConnected, boolean[] isVisited, int node) {
        isVisited[node] = true;
        for (int i = 0; i < isConnected[node].length; i++) {
            if (isConnected[node][i] == 1 && !isVisited[i])
                traverse(isConnected, isVisited, i);
        }
    }
}
