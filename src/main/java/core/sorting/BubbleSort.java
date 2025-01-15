package main.java.core.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {123, 345, 43, 4, 3, 15, 54};
        recursiveBubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void recursiveBubbleSort(int[] arr, int size) {
        if (size == 1)
            return;
        boolean swapped = false;
        for (int j = 0; j < size - 1; j++) {

            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (swapped)
            recursiveBubbleSort(arr, size - 1);
    }
}
