package main.java.leetcode.datastructure.array;

import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 ****************************/
public class NAndItsDoubleExists {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }

    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (set.contains(2 * n)
                    || (set.contains(n / 2) && n % 2 == 0))
                return true;
            set.add(n);
        }
        return false;
    }
}
