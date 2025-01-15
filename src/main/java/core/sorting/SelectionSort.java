package main.java.core.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {123, 345, 43, 4, 3, 15, 54};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            arr[i] = temp;
        }
    }

    public static void stableSelectionSort(int[] a) {
        // Iterate through array elements
        for (int i = 0; i < a.length - 1; i++) {
            // Loop invariant : Elements till
            // a[i - 1] are already sorted.

            // Find minimum element from
            // arr[i] to arr[n - 1].
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[min] > a[j])
                    min = j;

            // Move minimum element at current i.
            int key = a[min];
            while (min > i) {
                a[min] = a[min - 1];
                min--;
            }

            a[i] = key;
        }
    }
}
