package main.java.leetcode.datatype.numbers;

/***************************
 https://leetcode.com/problems/perfect-number/
 A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

 Given an integer n, return true if n is a perfect number, otherwise return false.
 ****************************/
public class PerfectDivisorNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(1));
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        if (num == 1)
            return false;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                sum += i + num / i;
        }
        sum++;
        return sum == num;
    }
}
