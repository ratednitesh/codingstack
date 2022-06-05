package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************
 * https://leetcode.com/problems/n-queens/
 ****************************/
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> l = solveNQueens(4);
        for (List<String> q : l) {
            System.out.println(q);
            System.out.println();
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        List<Integer> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            board.add(-1);
        placeQueens(0, board, result);
        return result;
    }

    private static void placeQueens(int c, List<Integer> board, List<List<String>> result) {
        if (c == board.size()) {
            List<String> list = new ArrayList<>();
            for (int k : board) {

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < board.size(); i++) {
                    if (i == k)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            result.add(list);
        } else {

            for (int i = 0; i < board.size(); i++) {
                boolean flag = false;

                for (int r = 0; r < c; r++) {
                    if (board.get(r) == i || Math.abs(board.get(r) - i) == (c - r)) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    continue;
                board.set(c, i);
                placeQueens(c + 1, board, result);
                board.set(c, -1);
            }
        }
    }

    // Approach 2: TODO: understand below logic
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 0, new boolean[n], new boolean[2 * n], new boolean[2 * n], n);
        return result;
    }

    private void helper(List<List<String>> result, List<String> board, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            result.add(new ArrayList<>(board));
        }
        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if (!cols[col] && !d1[id1] && !d2[id2]) {
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[col] = 'Q';
                board.add(new String(r));
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                helper(result, board, row + 1, cols, d1, d2, n);
                board.remove(board.size() - 1);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
