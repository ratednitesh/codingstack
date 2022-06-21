package main.java.leetcode.datastructure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***************************
 *https://leetcode.com/problems/jump-game-ii/
 ****************************/
public class JumpGame2 {
    public static void main(String[] args) {

    }

    // Greedy Solution inspired by BFS - Optimal
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int depth = 0, currMax = 0, nextMax = 0, index = 0, size = 1;
        while (size > 0) {
            depth++;
            for (; index <= currMax; index++) {
                nextMax = Math.max(nextMax, nums[index] + index);
                if (nextMax >= n - 1) return depth;
            }
            currMax = nextMax;
            size = currMax - index + 1;

        }
        return 123; // unreachable code
    }

    // BFS Solution
    public int jumpBFS(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        boolean[] isVisited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        isVisited[0] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();

                for (int j = 1; j <= nums[index]; j++) {
                    int neighbour = index + j;
                    if (neighbour >= n - 1)
                        return depth; // don't go beyond array size
                    if (!isVisited[neighbour]) {
                        isVisited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }

        }
        return -1;
    }

    // DP Solution
    public int jumpDP(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= i + nums[i] && j < n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }
}
