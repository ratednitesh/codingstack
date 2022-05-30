package main.java.leetcode.datatype.numbers;

import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/happy-number/
 ****************************/
public class HappyNumbers {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(isHappy(319));
    }

    // Using HashSet
    public static boolean isHappy(int n) {

        HashSet<Integer> hs = new HashSet<>();
        while (hs.add(n)) {

            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1)
                return true;
            else
                n = sum;
        }
        return false;
    }

    // Using Two Pointers
    public static boolean isHappyTP(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        else return false;
    }

    private static int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
