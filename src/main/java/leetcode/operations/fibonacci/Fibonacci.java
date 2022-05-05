package main.java.leetcode.operations.fibonacci;

/***************************
 https://leetcode.com/problems/fibonacci-number/
 ****************************/
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        if (n == 1) return 1;
        int ans = 0;
        int a = 0;
        int b = 1;
        int count = 0;
        while (count < n - 1) {
            ans = a + b;
            count++;
            a = b;
            b = ans;
        }
        return ans;
    }
}
