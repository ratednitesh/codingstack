package main.java.leetcode.datastructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/relative-ranks/
 ****************************/
public class RelativeRanks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            pq.offer(new int[]{score[i], i});
        }
        int rank = 1;
        while (!pq.isEmpty()) {
            if (rank == 1)
                result[pq.poll()[1]] = "Gold Medal";
            else if (rank == 2)
                result[pq.poll()[1]] = "Silver Medal";
            else if (rank == 3)
                result[pq.poll()[1]] = "Bronze Medal";
            else
                result[pq.poll()[1]] = String.valueOf(rank);
            rank++;
        }
        return result;
    }
}
