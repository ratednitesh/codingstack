package main.java.leetcode.operations.bitwise;

/***************************
 * https://leetcode.com/problems/single-number/
 ****************************/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }

    public static int singleNumber(int[] nums) {
        // XOR operation of two same numbers returns 0.
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
