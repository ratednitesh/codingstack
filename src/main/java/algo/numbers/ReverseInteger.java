package main.java.algo.numbers;
/***************************
 https://leetcode.com/problems/reverse-integer/
****************************/
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int a = 0;
        while(x!=0){
            if(Integer.MAX_VALUE/10 < a || a*10 > Integer.MAX_VALUE- x%10  )
                return 0;
            a = a*10+ x%10;
            x /=10;

        }
        return a*sign;
    }
}
