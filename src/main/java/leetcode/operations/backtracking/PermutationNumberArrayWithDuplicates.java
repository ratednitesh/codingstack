package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************
 * https://leetcode.com/problems/permutations-ii/
 ****************************/
public class PermutationNumberArrayWithDuplicates {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2, 3}));
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
}
