package main.java.leetcode.datastructure.hashmap;

import java.util.Arrays;
import java.util.HashSet;

/***************************
 * https://leetcode.com/problems/intersection-of-two-arrays/
 ****************************/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        int[] arr2 = {2, 2, 2};
        System.out.println(Arrays.toString(intersection(arr, arr2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for (int n : nums1)
            hs.add(n);

        for (int n : nums2) {
            if (hs.contains(n))
                hs2.add(n);
        }
        int[] result = new int[hs2.size()];
        int i = 0;
        for (int n : hs2) {
            result[i++] = n;
        }
        return result;
    }
}
