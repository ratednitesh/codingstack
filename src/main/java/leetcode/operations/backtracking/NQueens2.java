package main.java.leetcode.operations.backtracking;

import java.util.ArrayList;
import java.util.List;

/***************************
 * https://leetcode.com/problems/n-queens-ii/
 ****************************/
public class NQueens2 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        List<Integer> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            board.add(-1);
        return placeQueens(n, board, 0);
    }

    public static int placeQueens(int n, List<Integer> board, int row) {
        if (row == board.size())
            return 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int r = 0; r < row; r++) {
                if (board.get(r) == i || (Math.abs(i - board.get(r)) == row - r)) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            board.set(row, i);
            sum += placeQueens(n, board, row + 1);
            board.set(row, -1);
        }
        return sum;
    }
    // TODO: more optimized approach
}
