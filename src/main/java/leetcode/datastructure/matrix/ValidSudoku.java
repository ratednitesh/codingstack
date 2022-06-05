package main.java.leetcode.datastructure.matrix;

import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/valid-sudoku/
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 ****************************/
public class ValidSudoku {
    public boolean isValidSudokuHS(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.')
                    if (!hs.add(board[i][j] + " is at row " + i) || !hs.add(board[i][j] + " is at col " + j) || !hs.add(board[i][j] + " is at grid " + i / 3 + "-" + j / 3))
                        return false;
        }
        return true;
    }

    // More optimal - TODO: Need to understand below solution using Bitwise
    public boolean isValidSudoku(char[][] board) {
        int[] vset = new int[9];
        int[] hset = new int[9];
        int[] bckt = new int[9];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    idx = 1 << (board[i][j] - '0');
                    if ((hset[i] & idx) > 0 ||
                            (vset[j] & idx) > 0 ||
                            (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
                    hset[i] |= idx;
                    vset[j] |= idx;
                    bckt[(i / 3) * 3 + j / 3] |= idx;
                }
            }
        }
        return true;
    }

}
