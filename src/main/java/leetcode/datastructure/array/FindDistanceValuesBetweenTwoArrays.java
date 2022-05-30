package main.java.leetcode.datastructure.array;

import java.util.Arrays;

/***************************
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 ****************************/
public class FindDistanceValuesBetweenTwoArrays {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        System.out.println(findTheDistanceValue(arr, arr2, 2));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int val : arr1) {
            int start = 0, end = arr2.length - 1;
            if (notInRange(arr2, val - d, val + d)) {
                ans++;
            }
        }
        return ans;
    }

    private static boolean notInRange(int[] arr, int from, int to) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= from && arr[mid] <= to) {
                return false;
            } else if (arr[mid] < from) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return true;
    }
}
