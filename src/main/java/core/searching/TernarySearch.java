package main.java.core.searching;

public class TernarySearch {
    public static boolean ternarySearch(int[] arr, int lo, int hi, int target) {
        if (hi >= lo) {
            int mid1 = lo + (hi - lo) / 3;
            int mid2 = mid1 + (hi - lo) / 3;
            if (arr[mid1] == target)
                return true;
            if (arr[mid2] == target)
                return true;
            if (arr[mid1] > target)
                return ternarySearch(arr, lo, mid1 - 1, target);
            if (arr[mid2] < target)
                return ternarySearch(arr, mid2 + 1, hi, target);
            return ternarySearch(arr, mid1 + 1, mid2 - 1, target);
        }
        return false;
    }
}
