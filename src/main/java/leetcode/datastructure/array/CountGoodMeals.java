package main.java.leetcode.datastructure.array;

import java.util.HashMap;

/***************************
 * https://leetcode.com/problems/count-good-meals/
 ****************************/
public class CountGoodMeals {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println(countPairs(arr));
    }

    public static int countPairs(int[] deliciousness) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int j : deliciousness) {
            int n = 1;
            for (int i = 0; i <= 21; i++) {
                if (hm.containsKey(n - j)) {
                    count += hm.get(n - j);
                    count %= 1000000007;
                }
                n = n * 2;
            }
            hm.put(j, hm.getOrDefault(j, 0) + 1);
        }
        return count;
    }
}
