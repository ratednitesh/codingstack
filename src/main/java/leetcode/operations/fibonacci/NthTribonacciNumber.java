package main.java.leetcode.operations.fibonacci;

/***************************
 * https://leetcode.com/problems/n-th-tribonacci-number/
 ****************************/
public class NthTribonacciNumber {
    public static void main(String[] args) {

    }

    // recursion with cache -  memoization
    int[] cache;

    public int tribonacci(int n) {
        if (n <= 1)
            return n;
        if (n == 2)
            return 1;
        if (cache == null)
            cache = new int[n + 1];
        if (cache[n] != 0)
            return cache[n];
        cache[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        return cache[n];
    }

    // constant space dp
    public int tribonacciDP(int n) {
        if (n <= 1)
            return n;
        if (n == 2)
            return 1;
        int x = 0, y = 1, z = 1, ans = 0;
        int count = 2;
        while (count < n) {
            ans = x + y + z;
            x = y;
            y = z;
            z = ans;
            count++;
        }
        return ans;
    }
}
