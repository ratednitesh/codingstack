package main.java.leetcode.datastructure.hashmap;

import java.util.HashMap;

/***************************
* https://leetcode.com/problems/replace-elements-in-an-array/
****************************/
public class ReplaceElementsInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int index = hm.get(operation[0]);
            hm.remove(operation[0]);
            hm.put(operation[1], index);
        }
        for (int k : hm.keySet()) {
            nums[hm.get(k)] = k;
        }
        return nums;
    }
}
