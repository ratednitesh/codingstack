package main.java.leetcode.datastructure.graph;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 ****************************/
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4, 0}, {}}));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        backTrack(graph, 0, result, list);
        return result;
    }

    private static void backTrack(int[][] graph, int node, List<List<Integer>> result, ArrayList<Integer> list) {
        if (node == graph.length - 1)
            result.add(new ArrayList<>(list));

        for (int n : graph[node]) {
            if (list.contains(n)) continue;
            list.add(n);
            backTrack(graph, n, result, list);
            list.remove(list.size() - 1);
        }
    }
}
