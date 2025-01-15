package main.java.core.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 9};
        int target = 9;
        System.out.println(binarySearchRecur(arr, target, 0, arr.length - 1));
    }

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;

    }

    // recursive
    public static boolean binarySearchRecur(int[] arr, int target, int low, int high) {
        if (low > high)
            return false;
        int mid = low + (high - low) / 2;
        if (arr[mid] == target)
            return true;
        if (arr[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
        return binarySearchRecur(arr, target, low, high);
    }
}
