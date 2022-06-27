package main.java.leetcode.operations.dynamicProgramming;

import java.util.HashMap;
import java.util.PriorityQueue;

/***************************
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 ****************************/
public class SortIntegerByPowerValue {
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = lo; i <= hi; i++) {
            priorityQueue.offer(new int[]{util(i), i});
        }
        int i = 1;
        while (i < k) {
            priorityQueue.poll();
            i++;
        }
        return priorityQueue.poll()[1];
    }

    public int util(int num) {
        if (num == 1)
            return 0;
        if (dp.containsKey(num))
            return dp.get(num);
        if ((num & 1) == 0) {
            dp.put(num, util(num / 2) + 1);
        } else {
            dp.put(num, util(3 * num + 1) + 1);
        }
        return dp.get(num);
    }
}
