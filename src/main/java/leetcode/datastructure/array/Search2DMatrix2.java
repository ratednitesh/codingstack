package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 ****************************/
public class Search2DMatrix2 {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length - 1;
        int row = 0;
        while (column >= 0 && row < matrix.length) {
            if (matrix[row][column] == target)
                return true;
            if (matrix[row][column] < target)
                row++;
            else
                column--;
        }
        return false;
    }
}
