package main.java.leetcode.datastructure.array;

/***************************
 * https://leetcode.com/problems/search-a-2d-matrix/
 ****************************/
public class Search2DMatrix {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, low = 0, high = m * n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int midNum = matrix[mid / m][mid % m];
            if (midNum == target)
                return true;
            else if (midNum > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
