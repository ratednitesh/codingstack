package main.java.leetcode.operations.bitwise;

/***************************
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 ****************************/
public class BitwiseAndNumberRange {
//    The hardest part of this problem is to find the regular pattern.
//    For example, for number 26 to 30
//    Their binary form are:
//            11010
//            11011
//            11100　　
//            11101　　
//            11110
//
//    Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
//    So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
//
//    I think after understand this, the code is trivial:

    public int rangeBitwiseAnd(int m, int n) {
        int i = 0; // i means we have how many bits are 0 on the right
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }

    //approach 2
    public int rangeBitwiseAnd2(int left, int right) {
        if (left == 0) { // if smaller number is 0, ans is 0.
            return 0;
        }
        int moveFactor = 1; // answer will always be power of 2.
        while (left != right) {
            left >>= 1;
            right >>= 1;
            moveFactor <<= 1; // move to next power of 2.
        }
        return left * moveFactor;
    }
}
