package main.java.leetcode.datatype.numbers;
/***************************
* https://leetcode.com/problems/perfect-squares/
****************************/
public class PerfectSquares {

    public int numSquares(int n) {
        int arr[] = new int[n + 1]; // dp array
        return helper(n, arr);
    }

    public int helper(int n, int arr[]) {
        if (n < 0) return Integer.MAX_VALUE;  //Taking min later on
        if (n == 0) return 0; // if n is 0, ans is 0

        if (arr[n] > 0) return arr[n]; // using dp memoization

        int min = n; // min = n

        for (int i = 1; i * i <= n; i++) { // iterate to square of i.
            min = Math.min(min, helper(n - (i * i), arr)); // reduce n by i square
        }
        return arr[n] = min + 1; // add 1 for current
    }
}
