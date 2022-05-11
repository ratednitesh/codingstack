package main.java.leetcode.datastructure.heap;

import java.util.*;

/***************************
 * https://leetcode.com/problems/top-k-frequent-elements/
 ****************************/
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (int n : nums)
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (pq.size() < k)
                pq.offer(entry);
            else if (entry.getValue() > pq.peek().getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty())
            result[i++] = pq.poll().getKey();
        return result;
    }
}
