package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/combination-sum-iii/
 ****************************/
public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), k, 1, n);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int k, int start, int target) {
        if (target < 0) return;
        if (list.size() == k) {
            if (target == 0)
                result.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= 9; i++) {
                list.add(i);
                backTrack(result, list, k, i + 1, target - i);
                list.remove(list.size() - 1);
            }
        }
    }
}
