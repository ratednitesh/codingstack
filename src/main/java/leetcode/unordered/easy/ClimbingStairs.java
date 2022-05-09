package main.java.leetcode.unordered.easy;

/***************************
 * https://leetcode.com/problems/climbing-stairs/
 ****************************/
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(7));
    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int secondLastStep = 1;
        int lastStep = 2;
        int nSteps = 0;
        for (int i = 3; i <= n; i++) {
            nSteps = lastStep + secondLastStep;
            secondLastStep = lastStep;
            lastStep = nSteps;
        }

        return nSteps;
    }
}
