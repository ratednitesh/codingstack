package main.java.algo.bitwise;
/***************************
 https://leetcode.com/problems/number-of-1-bits/
****************************/
public class HammingWeight {

    public static void main(String[] args) {
        String b= "00000010100101000001111010011100";
        int num = Integer.parseInt(b,2);
        System.out.println(num);
        System.out.println(hammingWeight(num));
    }
    public static int hammingWeight(int n) {
        int count =0;
        for(int i=0;i<32;i++){
            if((n&1)==1)
                count++;
            n>>=1;
        }
        return count;
    }
}
