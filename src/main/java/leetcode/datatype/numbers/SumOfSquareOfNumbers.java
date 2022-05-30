package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/sum-of-square-numbers/
 ****************************/
public class SumOfSquareOfNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(100000));
    }

    // Using two pointers
    public static boolean judgeSquareSum(int n) {
        int root = (int) Math.sqrt(n);
        long low = 0;
        long high = root;
        while (low <= high) {
            long sum = (low * low) + (high * high);
            if (sum == n) {
                return true;
            }
            if (sum > n) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }

    //using Binary Search
    public static boolean judgeSquareSumBS(int n) {
        long low = 0;
        long high = Math.min(n, Integer.MAX_VALUE / 2);
        while (low <= high) {
            long ls = low * low;
            long hs = high * high;

            long sum = ls + hs;
            if (sum == n) {
                return true;
            }
            long mid = low + (high - low) / 2;
            long ms = mid * mid;
            if (sum > n) {
                if (ms + ls > n)
                    high = mid - 1;
                else
                    high--;
            } else {
                if (ms + hs < n) {
                    low = mid + 1;
                } else {
                    low++;
                }
            }
        }
        return false;
    }
}
