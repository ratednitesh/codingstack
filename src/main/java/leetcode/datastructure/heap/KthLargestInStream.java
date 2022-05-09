package main.java.leetcode.datastructure.heap;

import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 ****************************/
public class KthLargestInStream {
    public static void main(String[] args) {
        KthLargestInStream k = new KthLargestInStream(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
        KthLargestInStream k2 = new KthLargestInStream(1, new int[]{});
        System.out.println(k2.add(-3));
        System.out.println(k2.add(-2));
        System.out.println(k2.add(-4));
        System.out.println(k2.add(0));
        System.out.println(k2.add(4));
    }

    PriorityQueue<Integer> minHeap;
    final int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k)
            minHeap.offer(val);
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
