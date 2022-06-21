package main.java.leetcode.operations.dynamicProgramming;

/***************************
 * https://leetcode.com/problems/divisor-game/
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 *
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 ****************************/
public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(divisorGame(3));
    }

    public static boolean divisorGame(int n) {
        // if n ==1: bob wins return false
        // if n == 2: alice = 1, n =1 | returns true
        // if n == 3; alice can take 1,2 of which 1 is legal , returns false
        // if n == 4; alice can take 1, n=3 returns true;
        // if n == 5; alice can take only 1.. returns false
        // if n == 6; alice takes 3; n =3 returns true
        // if n== 9 ; 1,3,
        if (n == 1)
            return false;
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    // mathematically
    public boolean divisorGameMath(int n) {
        return n % 2 == 0;
    }
}
