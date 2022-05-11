package main.java.leetcode.operations.twoPointers;

import java.util.*;

/***************************
 * https://leetcode.com/problems/3sum/
 ****************************/
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    // Approach 1: Using backtracking
    public static List<List<Integer>> threeSumBT(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start, int sum) {
        if (list.size() == 3) {
            if (sum == 0)
                result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backTrack(result, list, nums, i + 1, sum + nums[i]);
            list.remove(list.size() - 1);
        }
    }

    // Approach 2: Using HashMap
    public static List<List<Integer>> threeSumHM(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {    //in order to avoid duplicate triplets
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    //avoiding multiple triplet with same second elements
                    continue;
                }
                int sum = -nums[i] - nums[j];
                if (map.containsKey(sum) && map.get(sum) > j) {
                    //if the remaining sum exists and its position is not
                    // equal to last one then add to list
                    list.add(Arrays.asList(nums[i], nums[j], sum));
                    // distinct arrays as list getting stored in list
                }
            }
        }
        return list;
    }

    // Approach 3: Using two pointers
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}
