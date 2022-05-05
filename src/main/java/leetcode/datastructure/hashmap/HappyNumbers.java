package main.java.leetcode.datastructure.hashmap;

import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/happy-number/
 ****************************/
public class HappyNumbers {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(isHappy(319));
    }

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
}
