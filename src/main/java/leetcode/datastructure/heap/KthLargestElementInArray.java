package main.java.leetcode.datastructure.heap;

import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 ****************************/
public class KthLargestElementInArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int n : nums) {
            if (priorityQueue.size() < k)
                priorityQueue.offer(n);
            else if (n > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(n);
            }
        }
        return priorityQueue.peek();
    }
}
