package main.java.algo.bitwise;
/***************************
 https://leetcode.com/problems/reverse-bits/
 Input: n = 00000010100101000001111010011100
 Output:    964176192 (00111001011110000010100101000000)
 Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
****************************/

public class ReverseBits {
    public static void main(String[] args) {
        String b= "00000010100101000001111010011100";
        int num = Integer.parseInt(b,2);
        System.out.println(num);
        System.out.println(reverseBits(num));
    }
    public static int reverseBits(int n) {
        int rev=0;
        if(n==0)
            return 0;
        for (int i = 0; i < 32; i++) {
            rev<<=1;
            if((n & 1 )== 1){
                rev++;
            }
            n>>=1;
        }
        return rev;
    }
}

