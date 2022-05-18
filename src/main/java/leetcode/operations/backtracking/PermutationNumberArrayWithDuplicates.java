package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/***************************
 * https://leetcode.com/problems/permutations-ii/
 ****************************/
public class PermutationNumberArrayWithDuplicates {
    public static void main(String[] args) {
        System.out.println(permuteUniqueSwap(new int[]{1, 1, 2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                    continue;
                used[i] = true;
                list.add(nums[i]);
                backTrack(result, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    // Approach 2: Using swapping
    public static List<List<Integer>> permuteUniqueSwap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permHelper(result, nums, 0);
        return result;
    }

    private static void permHelper(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length - 1) {
            result.add(getList(nums));
        } else {
            HashSet<Integer> hs = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (hs.add(nums[i])) {
                    swap(nums, i, start);
                    permHelper(result, nums, start + 1);
                    swap(nums, i, start);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    private static List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums)
            list.add(i);
        return list;
    }
}
