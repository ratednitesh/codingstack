package main.java.leetcode.datastructure.heap;

import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 ****************************/
public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {

    }

    // Time limit exceeded:
    // Complexity: 2^n 
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        furthestBuilding(heights, 0, bricks, ladders);
        return maxIndex;
    }

    int maxIndex = 0;

    public void furthestBuilding(int[] heights, int index, int bricks, int ladders) {
        if (index == heights.length - 1) {
            maxIndex = heights.length - 1;
            return;
        }
        maxIndex = Math.max(maxIndex, index);

        if (heights[index] >= heights[index + 1])
            furthestBuilding(heights, index + 1, bricks, ladders);
        else {
            if (ladders > 0)
                furthestBuilding(heights, index + 1, bricks, ladders - 1);
            if (bricks >= heights[index + 1] - heights[index])
                furthestBuilding(heights, index + 1, bricks - (heights[index + 1] - heights[index]), ladders);
        }
    }

    // PriorityQueue Solution
    public int furthestBuildingPQ(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++) {
            int d = heights[i] - heights[i - 1];
            if (d > 0) {
                pq.offer(d);
            }
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }
            if (bricks < 0)
                return i - 1;
        }
        return heights.length - 1;
    }
}
