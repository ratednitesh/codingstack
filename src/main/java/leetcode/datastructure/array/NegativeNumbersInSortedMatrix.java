package main.java.leetcode.datastructure.array;

public class NegativeNumbersInSortedMatrix {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}}));
    }

    public static int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length, row = 0, startC = 0, endC = n;
        int result = 0;
        while (row < m) {
            while (startC < endC) {
                int midC = (startC + endC) / 2;
                if (grid[row][midC] < 0)
                    endC = midC;
                else
                    startC = midC + 1;
            }
            result += n - startC;
            endC = startC;
            startC = 0;
            row++;
        }
        return result;
    }
}
