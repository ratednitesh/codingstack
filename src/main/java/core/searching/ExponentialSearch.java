package main.java.core.searching;

import java.util.Arrays;

public class ExponentialSearch {
    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target)
            return 0;
        int i = 1;
        while (i < arr.length && arr[i] <= target)
            i *= 2;
        return Arrays.binarySearch(arr, i / 2, Math.min(i, arr.length), target);
    }
}
