package main.java.leetcode.datastructure.heap;
/***************************
* https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
****************************/
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumDeletionToMakeCharFrequenciesUnique {
    public int minDeletions(String s) {
        int result = 0;
        int[] arr = new int[26];
        for (char c : s.toCharArray())
            arr[c - 'a']++;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : arr)
            if (a > 0)
                priorityQueue.offer(a);
        while (!priorityQueue.isEmpty()) {
            int maxFreq = priorityQueue.poll();
            if (priorityQueue.size() == 0)
                return result;
            if (maxFreq == priorityQueue.peek()) {
                if (maxFreq > 1) {
                    priorityQueue.offer(maxFreq - 1);
                }
                result++;
            }
        }
        return result;
    }

    public int minDeletions2(String s) {
        int[] arr = new int[26];
        int res = 0;
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = arr[i];
            while (freq > 0) {
                if (used.add(freq)) {
                    break;
                }
                freq--;
                res++;
            }
        }
        return res;
    }
}
