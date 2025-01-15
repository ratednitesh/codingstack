package main.java.core.searching;

public class InterpolationSearch {
    public static boolean interpolationSearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi && target >= arr[lo] && target <= arr[hi]) {
            int pos = lo + ((hi - lo) * (target - arr[lo]) / (arr[hi] - arr[lo]));
            if (arr[pos] == target)
                return true;
            else if (arr[pos] > target)
                hi = pos - 1;
            else
                lo = pos + 1;
        }
        return false;
    }
}
