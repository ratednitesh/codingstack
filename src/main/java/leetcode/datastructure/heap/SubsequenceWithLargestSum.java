package main.java.leetcode.datastructure.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 ****************************/
public class SubsequenceWithLargestSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{2, 1, 3, 3}, 2)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k)
                pq.offer(new int[]{nums[i], i});
            else if (pq.peek()[0] < nums[i]) {
                pq.poll();
                pq.offer(new int[]{nums[i], i});
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        while (!pq.isEmpty()) {
            hs.add(pq.poll()[1]);
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++)
            if (hs.contains(i))
                result[j++] = nums[i];
        return result;
    }
    // TODO: Quick select.
}
