package main.java.leetcode.datastructure.graph;

import java.util.*;

/***************************
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 ****************************/
public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][]{{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}}));
    }

    /* Approach and thought process:
    We need to find the shortest path hence BFS
    But it is different from normal BFS as same edge and node can be travelled multiple times.
    Starting point could be any node therefore we start with offering all nodes to queue instead of just '0'.
    When can we re-visit the same node? If going from 0->1 we can go back to 1->0 and then 0->2 but not 0->1 again.
    Visited array should take care that we are not following the same path again.
    One way to do so is, keep track of visited nodes in an HashSet this will stop from following the same path again (cycle)
    e.g. 0->1->0->1 is not allowed but 0->1->0->2 is allowed. Once we reach 0->1->0 HashSet will have {0,1}
    We need to have n such HashSets one for each node as the last node so far.
    Now if all nodes are present in any such HashSet we have travelled all nodes.

    Improving this solution:
    What if we could use integers bits as HashSet. Bit Masking can come to use here.
    Where 000000 means none of the nodes are visited and 11111 means all of them are...
    if all bits are set for a given node we have travelled all nodes.
    so, we need a visited 2d array of size[2^n][n]..
     */
    public static int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        int n = graph.length;

        // Adjency list of graph
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(i)) {
                hm.put(i, new ArrayList<Integer>());
            }

            int m = graph[i].length;
            for (int j = 0; j < m; j++) {
                hm.get(i).add(graph[i][j]);
            }

        }
        int row = (int) Math.pow(2, n), col = n;
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], -1);
        }
        for (int i = 0; i < graph.length; i++) {
            int lastNode = i;
            int mask = setBits(0, i);
            queue.offer(new int[]{lastNode, mask});
            visited[mask][lastNode] = 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] path = queue.poll();
                int lastNode = path[0];
                int mask = path[1];
                if (mask == row - 1)
                    return visited[mask][lastNode];
                for (int child : hm.get(lastNode)) {
                    int newLastNode = child;
                    int newMask = setBits(mask, newLastNode);
                    if (visited[newMask][newLastNode] != -1)
                        continue;
                    visited[newMask][newLastNode] = visited[mask][lastNode] + 1;
                    queue.offer(new int[]{newLastNode, newMask});
                }
            }
        }
        return -1;
    }

    private static int setBits(int i, int n) {
        return i | (1 << n);
    }
}
