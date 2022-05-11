package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/subsets/
 ****************************/
public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 3, 2}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
