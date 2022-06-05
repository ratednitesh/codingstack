package main.java.leetcode.datastructure.hashmap;

import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/contains-duplicate/
 ****************************/
public class ContainDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {

            if (!hs.add(n))
                return true;
        }
        return false;
    }
}
