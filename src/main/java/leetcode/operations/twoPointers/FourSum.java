package main.java.leetcode.operations.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************
 * https://leetcode.com/problems/4sum/
 ****************************/
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        if (nums[0] > target / 4 || nums[nums.length - 1] < target / 4)
            return result;
        backTrack(result, new ArrayList<>(), nums, 0, target);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start, int target) {

        if (start < nums.length && nums[start] >= 0 && target < 0)
            return;
        if (list.size() == 4) {
            if (target == 0)
                result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backTrack(result, list, nums, i + 1, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }

    // TODO: Two pointer approach.
}
