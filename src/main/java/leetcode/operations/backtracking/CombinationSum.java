package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/combination-sum/
 ****************************/
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
        if (target >= 0) {
            if (target == 0)
                result.add(new ArrayList<>(list));
            else {
                for (int i = start; i < candidates.length; i++) {
                    list.add(candidates[i]);
                    backTrack(result, list, candidates, target - candidates[i], i);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
