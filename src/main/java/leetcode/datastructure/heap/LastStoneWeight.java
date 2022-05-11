package main.java.leetcode.datastructure.heap;

import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/last-stone-weight/
 ****************************/
public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int s : stones)
            priorityQueue.offer(s);
        while (priorityQueue.size() > 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            if (first > second)
                priorityQueue.offer(first - second);
            else if (second > first)
                priorityQueue.offer(second - first);
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }

}
