package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 ****************************/
public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }

    public static int[] shortestToChar(String s, char c) {
        int n = s.length(), pos = -n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            result[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            result[i] = Math.min(pos - i, result[i]);
        }
        return result;
    }
}
