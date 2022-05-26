package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/combinations/
 ****************************/
public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public static void backTrack(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            backTrack(result, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
