package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/permutations/
 ****************************/
public class PermutationsNumberArray {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.println(permuteBT(arr));
    }

    static List<List<Integer>> al = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        perm(nums, 0, nums.length - 1);
        return al;
    }

    private static void perm(int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> l = new ArrayList<>();
            for (int n : nums) {
                l.add(n);
            }
            al.add(l);

        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                perm(nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    // Approach 2: using backTracking 
    public static List<List<Integer>> permuteBT(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), nums);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));
        else {
            for (int num : nums) {
                if (list.contains(num)) continue;
                list.add(num);
                backTrack(result, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
