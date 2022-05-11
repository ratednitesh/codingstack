package main.java.leetcode.datastructure.matrix;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/word-search/
 ****************************/
public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(arr, "ABCCED"));
        for (char[] c : arr)
            System.out.println(Arrays.toString(c));
    }

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (findChar(board, y, x, w, 0)) return true;
            }
        }
        return findChar(board, 0, 0, word.toCharArray(), 0);
    }

    public static boolean findChar(char[][] board, int x, int y, char[] word, int index) {
        if (index == word.length)
            return true;
        if (x < 0 || y < 0 || x == board.length || y == board[0].length || board[x][y] != word[index])
            return false;
        char temp = board[x][y];
        board[x][y] = '0';
        boolean e = findChar(board, x + 1, y, word, index + 1) || findChar(board, x - 1, y, word, index + 1)
                || findChar(board, x, y + 1, word, index + 1) || findChar(board, x, y - 1, word, index + 1);
        board[x][y] = temp;
        return e;
    }
}
