package main.java.core.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 8, 2, 1};
        int target = 7;
        System.out.println(linearSearchRecur(arr, target, 0));
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int a : arr) {
            if (a == target)
                return true;
        }
        return false;
    }

    // recursive
    public static boolean linearSearchRecur(int[] arr, int target, int index) {
        if (index == arr.length)
            return false;
        if (arr[index] == target)
            return true;
        else
            return linearSearchRecur(arr, target, index + 1);
    }
}
