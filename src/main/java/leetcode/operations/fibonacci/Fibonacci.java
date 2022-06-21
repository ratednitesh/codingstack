package main.java.leetcode.operations.fibonacci;

/***************************
 https://leetcode.com/problems/fibonacci-number/
 ****************************/
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(4));
    }

    // layman approach - technically this constant space dp solution
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

    // recursion approach
    public static int fibRecur(int n) {
        if (n <= 1)
            return n;
        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    // recursion with cache - memoization appraoch
    static int[] cache;

    public static int fibRecurCache(int n) {
        if (cache == null)
            cache = new int[n + 1];
        if (n <= 1)
            return n;
        if (cache[n] != 0)
            return cache[n];
        cache[n] = fibRecur(n - 1) + fibRecur(n - 2);
        return cache[n];
    }

    // dp approach
    public static int fibDP(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
