package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/sqrtx/
 ****************************/
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int sqRoot = -1;
        int low = 1;
        int high = x / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sq = (long) mid * (long) mid;
            if (sq == x)
                return mid;
            if (sq < x) {
                sqRoot = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return sqRoot;
    }
}
