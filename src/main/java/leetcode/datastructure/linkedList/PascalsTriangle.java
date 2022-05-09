package main.java.leetcode.datastructure.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***************************
 * https://leetcode.com/problems/pascals-triangle/
 ****************************/
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(13));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(0, 1);
            for (int j = 1; j < rows.size() - 1; j++) {
                rows.set(j, rows.get(j) + rows.get(j + 1));
            }
            allRows.add(new ArrayList<>(rows));
        }
        return allRows;
    }

    // Using DP
    public static List<List<Integer>> generateDP(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();
        if (numRows == 0) return allRows;
        allRows.add(new ArrayList<>(Collections.singletonList(1)));
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int left = allRows.get(i - 1).get(j - 1);
                int right = allRows.get(i - 1).get(j);
                row.add(left + right);
            }
            row.add(1);
            allRows.add(row);
        }
        return allRows;
    }

    public static List<List<Integer>> generateMaths(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            int val = 1;
            for (int j = 0; j <= i; j++) {
                temp.add(val);
                val = val * (i - j) / (j + 1);
            }
            ans.add(temp);
        }
        return ans;
    }
}
