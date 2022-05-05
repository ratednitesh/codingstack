package main.java.leetcode.datastructure.array;

import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/contains-duplicate-ii/
 ****************************/
public class ContainDuplicates2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(arr, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        for (int n : nums) {
            if (hm.containsKey(n)) {
                if (i - hm.get(n) <= k)
                    return true;
            }
            hm.put(n, i);
            i++;
        }
        return false;
    }
}
