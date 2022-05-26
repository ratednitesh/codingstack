package main.java.leetcode.datatype.numbers;

/***************************
 * https://leetcode.com/problems/kth-missing-positive-number/
 ****************************/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    }

    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] - 1 - mid < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low + k;
    }
}
