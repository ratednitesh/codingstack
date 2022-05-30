package main.java.leetcode.operations.bitwise;

/***************************
 * https://leetcode.com/problems/missing-number/
 ****************************/
public class BitwiseNumbers {
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
