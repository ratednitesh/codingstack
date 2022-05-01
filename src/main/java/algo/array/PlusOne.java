package main.java.algo.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/plus-one/
 ****************************/
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int l = digits.length - 1;
        for (int i = l; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[l + 2];
        newNum[0] = 1;
        return newNum;
    }

}
