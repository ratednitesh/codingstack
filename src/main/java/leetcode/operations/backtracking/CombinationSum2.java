package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************
 * https://leetcode.com/problems/combination-sum-ii/
 ****************************/
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
        if (target >= 0) {
            if (target == 0)
                result.add(new ArrayList<>(list));
            else {
                for (int i = start; i < candidates.length; i++) {
                    if (i > start && candidates[i] == candidates[i - 1]) continue;
                    list.add(candidates[i]);
                    backTrack(result, list, candidates, target - candidates[i], i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}